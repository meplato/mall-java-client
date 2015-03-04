package com.meplato.mall.mlt;

import com.meplato.mall.ServiceException;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoreLikeThisServiceTest extends com.meplato.mall.mlt.BaseTest {

    @Test
    public void testExecuteSuccess() throws ServiceException {
        com.meplato.mall.mlt.Service service = getMoreLikeThisService();
        assertNotNull(service);

        MoreLikeThisResponse response = service.moreLikeThis().view("default").q("stift").skip(0).take(10).execute();
        assertNotNull(response);
        assertTrue(response.getTotalItems() > 0);
        for (com.meplato.mall.mlt.Product product : response.getItems()) {
            assertNotNull(product);
            assertNotNull(product.getId());
            assertNotEquals("", product.getId());
            assertNotNull(product.getSpn());
            assertNotEquals("", product.getSpn());
            assertNotNull(product.getTitle());
            assertNotEquals("", product.getTitle());
        }
    }

    @Test
    public void testExecuteFailsWhenNotAuthorized() throws ServiceException {
        com.meplato.mall.mlt.Service service = getMoreLikeThisService();
        assertNotNull(service);
        service.setUser("");
        service.setPassword("");

        try {
            service.moreLikeThis().view("default").q("stift").skip(0).take(10).execute();
            fail("expected to not get data without authorization");
        } catch (ServiceException ex) {
            assertNotNull(ex);
            assertNotNull(ex.getError());
            assertEquals("Unauthorized", ex.getMessage());
        }
    }
}
