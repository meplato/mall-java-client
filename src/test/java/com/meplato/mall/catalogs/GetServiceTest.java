package com.meplato.mall.catalogs;

import com.meplato.mall.ServiceException;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetServiceTest extends com.meplato.mall.catalogs.BaseTest {

    @Test
    public void testGetSuccess() throws ServiceException {
        Service service = getCatalogsService();
        assertNotNull(service);

        Catalog catalog = service.get().id(13).execute();
        assertNotNull(catalog);
        assertNotNull(catalog.getId());
        assertNotEquals("", catalog.getId());
        assertNotNull(catalog.getTitle());
        assertNotEquals("", catalog.getTitle());
    }

    @Test
    public void testGetFailsWhenNotAuthorized() throws ServiceException {
        Service service = getCatalogsService();
        assertNotNull(service);
        service.setUser("");
        service.setPassword("");

        try {
            service.get().id(13).execute();
            fail("expected to not get data without authorization");
        } catch (ServiceException ex) {
            assertNotNull(ex);
            assertNotNull(ex.getError());
            assertEquals("Unauthorized", ex.getMessage());
        }
    }
}
