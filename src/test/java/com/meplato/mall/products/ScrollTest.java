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

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests scrolling through the products of a catalog.
 */
public class ScrollTest extends BaseTest {
    @Test
    public void testProductsScroll() throws ServiceException, IOException, HttpException {
        Service service = getProductsService();
        assertNotNull(service);

        String pageToken = null;

        // Get 1st page
        this.mockResponseFromFile("products.scroll.success.1");
        ScrollResponse response = service.scroll().catalogId(5).pageToken("").execute();
        assertNotNull(response);
        assertNotNull(response.getKind());
        assertNotNull(response.getTotalItems());
        Product[] products = response.getItems();
        if (products != null) {
            for (Product product : products) {
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
        }
        pageToken = response.getPageToken();
        // This is a possible test to break a loop retrieving products from Store.
        /*
            if (pageToken == null || Objects.equals(pageToken, "")) {
                break;
            }
         */

        // Get 2nd page of results
        this.mockResponseFromFile("products.scroll.success.2");
        response = service.scroll().catalogId(5).pageToken(pageToken).execute();
        assertNotNull(response);
        assertNotNull(response.getKind());
        assertNotNull(response.getTotalItems());
        products = response.getItems();
        if (products != null) {
            for (Product product : products) {
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
        }
    }
}
