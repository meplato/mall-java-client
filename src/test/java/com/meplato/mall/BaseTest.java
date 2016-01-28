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

import com.meplato.mall.catalogs.CatalogsService;
import com.meplato.mall.mlt.MLTService;
import com.meplato.mall.products.ProductsService;
import com.meplato.mall.vendors.VendorsService;
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

    public CatalogsService getCatalogsService() {
        CatalogsService service = new CatalogsService(getClient());
        service.setBaseURL(BASE_URL);
        return service;
    }

    public MLTService getMoreLikeThisService() {
        MLTService service = new MLTService(getClient());
        service.setBaseURL(BASE_URL);
        return service;
    }

    public ProductsService getProductsService() {
        ProductsService service = new ProductsService(getClient());
        service.setBaseURL(BASE_URL);
        return service;
    }

    public VendorsService getVendorsService() {
        VendorsService service = new VendorsService(getClient());
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
