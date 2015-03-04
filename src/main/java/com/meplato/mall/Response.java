package com.meplato.mall;

/**
 * Response from a Client.
 */
public interface Response {
    int getStatusCode();

    String getBody();

    <T> T getBodyJSON(Class<T> clazz);
}
