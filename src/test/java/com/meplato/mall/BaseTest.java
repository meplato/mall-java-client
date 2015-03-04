package com.meplato.mall;

import org.junit.After;
import org.junit.Before;

/**
 * Created by oliver on 23.01.15.
 */
public abstract class BaseTest {
    private static final String BASE_URL = "http://mall.go/api/v1";

    private Client client;

    protected BaseTest() {
    }

    public Client getClient() {
        if (client == null) {
            client = new ApacheHttpClient();
        }
        return client;
    }

    private String getUsernameFromEnv() {
        return System.getenv("MALL_USER");
    }

    private String getPasswordFromEnv() {
        return System.getenv("MALL_PASSWORD");
    }

    protected String getCatalogPINFromEnv() {
        return System.getenv("MALL_PIN");
    }

    /*
    public Service getService() {
        Service service = new Service(getClient());
        service.setBaseURL(BASE_URL);
        service.setUser(getUsernameFromEnv());
        service.setPassword(getPasswordFromEnv());
        return service;
    }
    */

    public com.meplato.mall.catalogs.Service getCatalogsService() {
        com.meplato.mall.catalogs.Service service = new com.meplato.mall.catalogs.Service(getClient());
        service.setBaseURL(BASE_URL);
        service.setUser(getUsernameFromEnv());
        service.setPassword(getPasswordFromEnv());
        return service;
    }

    public com.meplato.mall.products.Service getProductsService() {
        com.meplato.mall.products.Service service = new com.meplato.mall.products.Service(getClient());
        service.setBaseURL(BASE_URL);
        service.setUser(getUsernameFromEnv());
        service.setPassword(getPasswordFromEnv());
        return service;
    }

    public com.meplato.mall.mlt.Service getMoreLikeThisService() {
        com.meplato.mall.mlt.Service service = new com.meplato.mall.mlt.Service(getClient());
        service.setBaseURL(BASE_URL);
        service.setUser(getUsernameFromEnv());
        service.setPassword(getPasswordFromEnv());
        return service;
    }

    @Before
    public void beforeTest() throws ServiceException {
    }

    @After
    public void afterTest() throws ServiceException {
    }

}
