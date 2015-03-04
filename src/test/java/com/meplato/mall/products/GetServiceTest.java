package com.meplato.mall.products;

import com.meplato.mall.ServiceException;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetServiceTest extends BaseTest {

    @Test
    public void testGetSuccess() throws ServiceException {
        Service service = getProductsService();
        assertNotNull(service);

        Product product = service.get().view("default").id("103131@13").execute();
        assertNotNull(product);
        assertNotNull(product.getId());
        assertNotEquals("", product.getId());
        assertNotNull(product.getSpn());
        assertNotEquals("", product.getSpn());
        assertNotNull(product.getTitle());
        assertNotEquals("", product.getTitle());
    }

    @Test
    public void testGetFailsWhenNotAuthorized() throws ServiceException {
        Service service = getProductsService();
        assertNotNull(service);
        service.setUser("");
        service.setPassword("");

        try {
            service.get().view("default").id("101761@1").execute();
            fail("expected to not get data without authorization");
        } catch (ServiceException ex) {
            assertNotNull(ex);
            assertNotNull(ex.getError());
            assertEquals("Unauthorized", ex.getMessage());
        }
    }
}
