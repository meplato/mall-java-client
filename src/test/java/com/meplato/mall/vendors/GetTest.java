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
package com.meplato.mall.vendors;

import com.meplato.mall.ServiceException;
import org.apache.http.HttpException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Tests getting a vendor.
 */
public class GetTest extends BaseTest {

    @Test
    public void testVendorGet() throws ServiceException, IOException, HttpException {
        this.mockResponseFromFile("vendors.get.success");

        VendorsService service = getVendorsService();
        assertNotNull(service);

        Vendor vendor = service.get().id(8).execute();
        assertNotNull(vendor);
        assertTrue(vendor.getId() > 0);
        assertNotNull(vendor.getName());
        assertNotEquals("", vendor.getName());
        assertNotNull(vendor.getCreated());
        assertNotNull(vendor.getUpdated());
    }

    @Test
    public void testVendorNotFound() throws ServiceException, IOException, HttpException {
        this.mockResponseFromFile("vendors.get.not_found");

        VendorsService service = getVendorsService();
        assertNotNull(service);

        try {
            service.get().id(54321).execute();
            fail("expected to not get data");
        } catch (ServiceException ex) {
            assertNotNull(ex);
            assertNotNull(ex.getError());
            assertEquals("Vendor not found", ex.getMessage());
        }
    }

    @Test
    public void testVendorsGetUnauthorized() throws ServiceException, IOException, HttpException {
        this.mockResponseFromFile("vendors.get.unauthorized");

        VendorsService service = getVendorsService();
        assertNotNull(service);
        service.setUser("");
        service.setPassword("");

        try {
            service.get().id(8).execute();
            fail("expected to not get data without authorization");
        } catch (ServiceException ex) {
            assertNotNull(ex);
            assertNotNull(ex.getError());
            assertEquals("Unauthorized", ex.getMessage());
        }
    }
}
