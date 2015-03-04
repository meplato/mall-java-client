package com.meplato.mall.catalogs;

import com.meplato.mall.ServiceException;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchServiceTest extends BaseTest {

    @Test
    public void testExecuteSuccess() throws ServiceException {
        Service service = getCatalogsService();
        assertNotNull(service);

        SearchResponse response = service.search().sort("id,created").skip(0).take(1).execute();
        assertNotNull(response);
        assertTrue(response.getTotalItems() > 0);
        for (Catalog catalog : response.getItems()) {
            assertNotNull(catalog);
            assertNotNull(catalog.getId());
            assertNotEquals("", catalog.getId());
            assertNotNull(catalog.getTitle());
            assertNotEquals("", catalog.getTitle());
        }
    }

    @Test
    public void testExecuteFailsWhenNotAuthorized() throws ServiceException {
        Service service = getCatalogsService();
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
