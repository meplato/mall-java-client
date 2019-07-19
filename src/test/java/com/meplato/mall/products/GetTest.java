/*
 * Copyright (c) 2015-2019 Meplato GmbH.
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
package com.meplato.mall.products;

import com.meplato.mall.ServiceException;
import org.apache.http.HttpException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Tests getting a product.
 */
public class GetTest extends BaseTest {

    @Test
    public void testProductGet() throws ServiceException, IOException, HttpException {
        assertNotNull(this.mockResponseFromFile("products.get.success"));

        Service service = getProductsService();
        assertNotNull(service);

        Product product = service.get().view("default").id("982790@6").execute();
        assertNotNull(product);
        assertNotNull(product.getId());
        assertNotEquals("", product.getId());
        assertNotNull(product.getSpn());
        assertNotEquals("", product.getSpn());
        assertNotNull(product.getName());
        assertNotEquals("", product.getName());
        assertNotNull(product.getCreated());
        assertNotNull(product.getUpdated());
    }

    @Test
    public void testProductGetNotFound() throws ServiceException, IOException, HttpException {
        this.mockResponseFromFile("products.get.not_found");

        Service service = getProductsService();
        assertNotNull(service);

        try {
            service.get().view("default").id("no-such-product").execute();
            fail("expected to not get data");
        } catch (ServiceException ex) {
            assertNotNull(ex);
            assertNotNull(ex.getError());
            assertEquals("Product not found", ex.getMessage());
        }
    }

    @Test
    public void testProductGetUnauthorized() throws ServiceException, IOException, HttpException {
        this.mockResponseFromFile("products.get.unauthorized");

        Service service = getProductsService();
        assertNotNull(service);
        service.setUser("");
        service.setPassword("");

        try {
            service.get().view("default").id("no-such-product").execute();
            fail("expected to not get data without authorization");
        } catch (ServiceException ex) {
            assertNotNull(ex);
            assertNotNull(ex.getError());
            assertEquals("Unauthorized", ex.getMessage());
        }
    }
}
