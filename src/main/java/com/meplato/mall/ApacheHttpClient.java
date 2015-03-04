package com.meplato.mall;

import com.damnhandy.uri.template.UriTemplate;
import com.google.gson.Gson;
import com.meplato.mall.products.Service;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * ApacheHttpClient implements Client for org.apache.http.
 */
public class ApacheHttpClient implements Client {
    private final CloseableHttpClient httpClient;

    public ApacheHttpClient() {
        httpClient = HttpClients.createDefault();
    }

    @Override
    public <T> Response execute(String method, String uriTemplate, Map<String, Object> parameters, Map<String, String> headers, Object body) throws ServiceException {
        // URI template parameters
        String url = UriTemplate.fromTemplate(uriTemplate).expand(parameters);

        // Body
        HttpEntity requestEntity = null;
        if (body != null) {
            Gson gson = Service.getSerializer();
            try {
                requestEntity = new StringEntity(gson.toJson(body));
            } catch (UnsupportedEncodingException e) {
                throw new ServiceException("Error serializing body", null, e);
            }
        }

        // Do HTTP request
        HttpRequestBase httpRequest = null;
        if (method.equalsIgnoreCase("GET")) {
            httpRequest = new HttpGet(url);
        } else if (method.equalsIgnoreCase("POST")) {
            HttpPost httpPost = new HttpPost(url);
            if (requestEntity != null) {
                httpPost.setEntity(requestEntity);
            }
            httpRequest = httpPost;
        } else if (method.equalsIgnoreCase("PUT")) {
            HttpPut httpPut = new HttpPut(url);
            if (requestEntity != null) {
                httpPut.setEntity(requestEntity);
            }
            httpRequest = httpPut;
        } else if (method.equalsIgnoreCase("DELETE")) {
            httpRequest = new HttpDelete(url);
        } else if (method.equalsIgnoreCase("PATCH")) {
            HttpPatch httpPatch = new HttpPatch(url);
            if (requestEntity != null) {
                httpPatch.setEntity(requestEntity);
            }
            httpRequest = httpPatch;
        } else if (method.equalsIgnoreCase("HEAD")) {
            httpRequest = new HttpHead(url);
        } else if (method.equalsIgnoreCase("OPTIONS")) {
            httpRequest = new HttpOptions(url);
        } else {
            throw new ServiceException("Invalid HTTP method: " + method, null, null);
        }

        // Headers
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            httpRequest.addHeader(entry.getKey(), entry.getValue());
        }

        try (CloseableHttpResponse httpResponse = httpClient.execute(httpRequest)) {
            Response response = new ApacheHttpResponse(httpResponse);
            int statusCode = response.getStatusCode();
            if (statusCode >= 200 && statusCode < 300) {
                return response;
            }
            throw ServiceException.fromResponse(response);
        } catch (ClientProtocolException e) {
            throw new ServiceException("Client Protocol Exception", null, e);
        } catch (IOException e) {
            throw new ServiceException("IO Exception", null, e);
        }
    }
}
