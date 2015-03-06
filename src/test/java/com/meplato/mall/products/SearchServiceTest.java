package com.meplato.mall.products;

import com.meplato.mall.ServiceException;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchServiceTest extends BaseTest {

    @Test
    public void testExecuteSuccess() throws ServiceException {
        Service service = getProductsService();
        assertNotNull(service);

        SearchResponse response = service.search().view("default").skip(0).take(10).execute();
        assertNotNull(response);
        assertTrue(response.getTotalItems() > 0);
        for (Product product : response.getItems()) {
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
        Service service = getProductsService();
        assertNotNull(service);
        service.setUser("");
        service.setPassword("");

        try {
            service.search().view("default").skip(0).take(10).execute();
            fail("expected to not get data without authorization");
        } catch (ServiceException ex) {
            assertNotNull(ex);
            assertNotNull(ex.getError());
            assertEquals("Unauthorized", ex.getMessage());
        }
    }

    @Test
    public void testExecuteWithFacets() throws ServiceException {
        Service service = getProductsService();
        assertNotNull(service);

        SearchResponse response = service.search().view("default").f_manufacturers(true).f_prices(true).execute();
        assertNotNull(response);
        assertTrue(response.getTotalItems() > 0);
        for (Product product : response.getItems()) {
            assertNotNull(product);
            assertNotNull(product.getId());
            assertNotEquals("", product.getId());
            assertNotNull(product.getSpn());
            assertNotEquals("", product.getSpn());
            assertNotNull(product.getTitle());
            assertNotEquals("", product.getTitle());
        }

        SearchResponseFacets facets = response.getFacets();
        assertNotNull(facets);
        assertNull(facets.getCatalogs());

        assertNotNull(facets.getManufacturers());
        TermFacet facet = facets.getManufacturers();
        assertTrue(facet.getCount() > 0);
        assertNotNull(facet.getBuckets());
        for (TermBucket bucket : facet.getBuckets()) {
            assertNotNull(bucket);
            assertTrue(bucket.getCount() > 0);
            assertNotEquals("", bucket.getValue());
        }

        assertNotNull(facets.getPrices());
        RangeFacet prices = facets.getPrices();
        assertNotNull(prices.getBuckets());
        for (RangeBucket bucket : prices.getBuckets()) {
            assertNotNull(bucket);
            assertTrue(bucket.getCount() > 0);
        }
    }
}
