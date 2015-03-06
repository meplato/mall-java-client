package com.meplato.mall.products;

import com.meplato.mall.ServiceException;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class ScrollServiceTest extends BaseTest {

    @Test
    public void testExecuteSuccess() throws ServiceException {
        Service service = getProductsService();
        assertNotNull(service);

        String pageToken = null;
        while (true) {
            ScrollResponse response = service.scroll().catalogId(13).pageToken(pageToken).execute();
            assertNotNull(response);
            assertEquals("mall#products-scroll,v1", response.getKind());
            for (Product product : response.getItems()) {
                assertNotNull(product);
                assertNotNull(product.getId());
                assertNotEquals("", product.getId());
                assertNotNull(product.getSpn());
                assertNotEquals("", product.getSpn());
                assertNotNull(product.getTitle());
                assertNotEquals("", product.getTitle());
            }
            pageToken = response.getPageToken();
            if (pageToken == null) {
                assertNull(response.getNextLink());
                assertEquals(0, response.getTotalItems());
                break;
            }

            assertTrue(response.getTotalItems() > 0);
        }
    }

    @Test
    public void testExecuteFailsWhenNotAuthorized() throws ServiceException {
        Service service = getProductsService();
        assertNotNull(service);
        service.setUser("");
        service.setPassword("");

        try {
            service.scroll().catalogId(13).execute();
            fail("expected to not get data without authorization");
        } catch (ServiceException ex) {
            assertNotNull(ex);
            assertNotNull(ex.getError());
            assertEquals("Unauthorized", ex.getMessage());
        }
    }
}
