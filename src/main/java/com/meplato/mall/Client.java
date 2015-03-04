package com.meplato.mall;

import java.util.Map;

/**
 * Created by oliver on 23.01.15.
 */
public interface Client {
    <T> Response execute(String method, String uriTemplate, Map<String, Object> parameters, Map<String, String> headers, Object body) throws ServiceException;
}
