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
package com.meplato.mall.catalogs;

import com.meplato.mall.ServiceException;
import org.apache.http.HttpException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Tests getting a catalog.
 */
public class GetTest extends BaseTest {

    @Test
    public void testCatalogGet() throws ServiceException, IOException, HttpException {
        this.mockResponseFromFile("catalogs.get.success");

        Service service = getCatalogsService();
        assertNotNull(service);

        Catalog catalog = service.get().id(5).execute();
        assertNotNull(catalog);
        assertTrue(catalog.getId() > 0);
        assertNotNull(catalog.getTitle());
        assertNotEquals("", catalog.getTitle());
        assertNotNull(catalog.getCreated());
        assertNotNull(catalog.getUpdated());
        assertNotNull(catalog.getVendor());
    }

    @Test
    public void testCatalogNotFound() throws ServiceException, IOException, HttpException {
        this.mockResponseFromFile("catalogs.get.not_found");

        Service service = getCatalogsService();
        assertNotNull(service);

        try {
            service.get().id(54321).execute();
            fail("expected to not get data");
        } catch (ServiceException ex) {
            assertNotNull(ex);
            assertNotNull(ex.getError());
            assertEquals("Catalog not found", ex.getMessage());
        }
    }

    @Test
    public void testCatalogsGetUnauthorized() throws ServiceException, IOException, HttpException {
        this.mockResponseFromFile("catalogs.get.unauthorized");

        Service service = getCatalogsService();
        assertNotNull(service);
        service.setUser("");
        service.setPassword("");

        try {
            service.get().id(5).execute();
            fail("expected to not get data without authorization");
        } catch (ServiceException ex) {
            assertNotNull(ex);
            assertNotNull(ex.getError());
            assertEquals("Unauthorized", ex.getMessage());
        }
    }
}
