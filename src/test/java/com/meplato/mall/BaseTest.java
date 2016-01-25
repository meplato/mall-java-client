/*
 * Copyright (c) 2015 Meplato GmbH, Switzerland.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.meplato.mall;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpException;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;

/**
 * Base class for all tests.
 */
public abstract class BaseTest {
    protected static final String BASE_URL = "http://mall.go/api/v2";

    private MockClient client;

    protected BaseTest() {
    }

    public MockClient getClient() {
        if (client == null) {
            client = new MockClient();
        }
        return client;
    }

    public com.meplato.mall.catalogs.Service getCatalogsService() {
        com.meplato.mall.catalogs.Service service = new com.meplato.mall.catalogs.Service(getClient());
        service.setBaseURL(BASE_URL);
        return service;
    }

    public com.meplato.mall.mlt.Service getMoreLikeThisService() {
        com.meplato.mall.mlt.Service service = new com.meplato.mall.mlt.Service(getClient());
        service.setBaseURL(BASE_URL);
        return service;
    }

    public com.meplato.mall.products.Service getProductsService() {
        com.meplato.mall.products.Service service = new com.meplato.mall.products.Service(getClient());
        service.setBaseURL(BASE_URL);
        return service;
    }

    public com.meplato.mall.vendors.Service getVendorsService() {
        com.meplato.mall.vendors.Service service = new com.meplato.mall.vendors.Service(getClient());
        service.setBaseURL(BASE_URL);
        return service;
    }

    protected void mockResponse(Response response) {
        this.getClient().setResponse(response);
    }

    protected Response mockResponseFromFile(String filename) throws IOException, HttpException, ServiceException {
        String contents = IOUtils.toString(this.getClass().getResourceAsStream(filename), "UTF-8");
        Response response = MockResponse.fromContents(contents);
        this.mockResponse(response);
        return response;
    }

    protected void mockResponseException(ServiceException exception) {
        this.getClient().setServiceException(exception);
    }

    @Before
    public void beforeTest() throws ServiceException, Exception {
    }

    @After
    public void afterTest() throws ServiceException, Exception {
    }
}
