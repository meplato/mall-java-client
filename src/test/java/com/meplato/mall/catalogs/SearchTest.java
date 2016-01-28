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
package com.meplato.mall.catalogs;

import com.meplato.mall.ServiceException;
import org.apache.http.HttpException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Tests searching for/listing catalogs.
 */
public class SearchTest extends BaseTest {

    @Test
    public void testCatalogSearch() throws ServiceException, IOException, HttpException {
        this.mockResponseFromFile("catalogs.search.success");

        CatalogsService service = getCatalogsService();
        assertNotNull(service);

        SearchResponse response = service.search().skip(0).take(10).execute();
        assertNotNull(response);
        assertTrue(response.getTotalItems() > 0);
        for (Catalog catalog : response.getItems()) {
            assertNotNull(catalog);
            assertTrue(catalog.getId() > 0);
            assertNotNull(catalog.getTitle());
            assertNotEquals("", catalog.getTitle());
            assertNotNull(catalog.getCreated());
            assertNotNull(catalog.getUpdated());
        }
    }

    @Test
    public void testCatalogSearchAuthorized() throws ServiceException, IOException, HttpException {
        this.mockResponseFromFile("catalogs.search.unauthorized");

        CatalogsService service = getCatalogsService();
        assertNotNull(service);
        service.setUser("");
        service.setPassword("");

        try {
            service.search().skip(0).take(10).execute();
            fail("expected to not get data without authorization");
        } catch (ServiceException ex) {
            assertNotNull(ex);
            assertNotNull(ex.getError());
            assertEquals("Unauthorized", ex.getMessage());
        }
    }
}
