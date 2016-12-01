package com.meplato.mall;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;

/**
 * OkHttpResponse implements the Response interface for OkHttpClient.
 */
public class OkHttpResponse implements Response {
    /**
     * Status code of the HTTP response.
     */
    private final int statusCode;
    /**
     * Body of the HTTP response as a String.
     */
    private final String body;

    /**
     * Instantiates a new instance of OkHttpResponse,
     * then close the response.
     *
     * @param response the HTTP response from the OkHttpClient.
     * @throws ServiceException if e.g. serialization of the response fails.
     * @throws IOException if e.g. request body cannot be deserialized.
     */
    public OkHttpResponse(okhttp3.Response response) throws ServiceException, IOException {
        this.statusCode = response.code();
        ResponseBody responseBody = response.body();
        if (responseBody  != null) {
            this.body = responseBody.string();
        } else {
            this.body = null;
        }
    }

    /**
     * Returns the HTTP status code of the response.
     *
     * @return the HTTP status code.
     */
    @Override
    public int getStatusCode() {
        return this.statusCode;
    }

    /**
     * Returns the HTTP body of the response as a String.
     *
     * @return the body as a String.
     */
    @Override
    public String getBody() {
        return this.body;
    }

    /**
     * Unmarshals the HTTP body as an instance of T.
     *
     * @param clazz the class.
     * @param <T>   the type of the class to deserialize.
     * @return the deserialized object or {@code null}.
     */
    @Override
    public <T> T getBodyJSON(Class<T> clazz) {
        if (this.body != null) {
            Gson gson = OkHttpClient.getSerializer();
            return gson.fromJson(this.body, clazz);
        } else {
            return null;
        }
    }
}
