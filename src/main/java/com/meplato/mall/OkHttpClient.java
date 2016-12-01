package com.meplato.mall;

import com.damnhandy.uri.template.UriTemplate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;
import java.util.Map;

/**
 * OkHttpClient implements the Client interface with the OkHttp client by Square.
 *
 * OkHttp is a high-level client for the JVM that supports HTTP/2.0.
 */
public class OkHttpClient implements Client {
    /** JSON mime type */
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /** OkHttp client (capable of HTTP/2.0) */
    private final okhttp3.OkHttpClient httpClient;

    /** User Agent. */
    public static String USER_AGENT = "meplato-api-java-version-okhttp/1.0.0";
    /** RFC3339 pattern for deserializing date/time from the API. */
    public static String RFC3339 = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSSXXX";

    /**
     * Instantiates a new instance of OkHttpClient with the given
     * HttpClient.
     *
     * @param client the configured OkHttpClient to use
     */
    public OkHttpClient(okhttp3.OkHttpClient client) {
        httpClient = client;
    }

    public static Gson getSerializer() {
        return new GsonBuilder().setDateFormat(RFC3339).create();
    }

    /**
     * Execute runs a HTTP request/response with an API endpoint.
     *
     * @param method      the HTTP method, e.g. POST or GET
     * @param uriTemplate the URI template according to RFC 6570
     * @param parameters  the query string parameters
     * @param headers     the key/value pairs for the HTTP header
     * @param body        the body of the request or {@code null}
     * @return the HTTP response encapsulated by {@link Response}.
     * @throws ServiceException if e.g. the service is unavailable.
     */
    @Override
    public Response execute(String method, String uriTemplate, Map<String, Object> parameters, Map<String, String> headers, Object body) throws ServiceException {
        // URI template parameters
        String url = UriTemplate.fromTemplate(uriTemplate).expand(parameters);

        // Body handling
        RequestBody requestBody = null;
        if (body != null) {
            Gson gson = getSerializer();
            requestBody = RequestBody.create(JSON, gson.toJson(body));
        }

        Request.Builder builder = new Request.Builder()
                .url(url)
                .method(method, requestBody);

        // Headers
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            builder = builder.addHeader(entry.getKey(), entry.getValue());
        }
        builder = builder.addHeader("Accept", "application/json");
        builder = builder.addHeader("Accept-Charset", "utf-8");
        builder = builder.addHeader("User-Agent", USER_AGENT);
        // builder = builder.addHeader("Content-Type", "application/json; charset=utf-8");

        try {
            okhttp3.Request httpRequest = builder.build();
            okhttp3.Response httpResponse = this.httpClient.newCall(httpRequest).execute();
            Response response = new OkHttpResponse(httpResponse);
            int statusCode = response.getStatusCode();
            if (statusCode >= 200 && statusCode < 300) {
                return response;
            }
            throw ServiceException.fromResponse(response);
        } catch (IOException e) {
            throw new ServiceException("Client IOException", null, e);
        }
    }
}
