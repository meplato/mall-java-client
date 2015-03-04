package com.meplato.mall;

import com.google.gson.Gson;
import com.meplato.mall.products.Service;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * ApacheHttpResponse implements Response for org.apache.http.
 */
public class ApacheHttpResponse implements Response {
    private final int statusCode;
    private final String body;

    public ApacheHttpResponse(CloseableHttpResponse response) throws ServiceException {
        this.statusCode = response.getStatusLine().getStatusCode();

        HttpEntity entity = response.getEntity();
        if (entity != null) {
            try {
                Gson gson = Service.getSerializer();
                ContentType contentType = ContentType.getOrDefault(entity);
                Charset charset = contentType.getCharset();
                this.body = EntityUtils.toString(entity, charset);
            } catch (IOException e) {
                EntityUtils.consumeQuietly(entity);
                throw new ServiceException("Error deserializing data", null, e);
            } finally {
                try {
                    response.close();
                } catch (IOException e) {
                }
            }
        } else {
            this.body = null;
        }
    }

    @Override
    public int getStatusCode() {
        return this.statusCode;
    }

    @Override
    public String getBody() {
        return this.body;
    }

    @Override
    public <T> T getBodyJSON(Class<T> clazz) {
        if (this.body != null) {
            Gson gson = Service.getSerializer();
            return gson.fromJson(this.body, clazz);
        } else {
            return null;
        }

    }
}
