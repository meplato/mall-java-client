package com.meplato.mall;

import com.meplato.mall.products.Service;
import org.junit.After;
import org.junit.Before;

/**
 * Created by oliver on 23.01.15.
 */
public abstract class BaseTest {
    private static final String BASE_URL = null; // "http://mall.go/api/v1";
    private static final String USER = null; // <your-api-key-here>
    private static final String PASSWORD = null;

    private Client client;
    private String baseURL, user, password;

    protected BaseTest() {
        setBaseURL(BASE_URL);
        setUser(USER);
        setPassword(PASSWORD);
    }

    protected Client getClient() {
        if (client == null) {
            client = new ApacheHttpClient();
        }
        return client;
    }

    protected String getBaseURL() {
        if (baseURL == null) {
            return Service.BASE_URL;
        }
        return baseURL;
    }

    protected void setBaseURL(String baseURL) {
         this.baseURL= baseURL;
    }

    protected String getUser() {
        if (user == null) {
            return System.getenv("MALL_USER");
        }
        return user;
    }

    protected void setUser(String user) {
        this.user = user;
    }

    protected String getPassword() {
        if (password == null) {
            return System.getenv("MALL_PASSWORD");
        }
        return password;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    protected com.meplato.mall.catalogs.Service getCatalogsService() {
        com.meplato.mall.catalogs.Service service = new com.meplato.mall.catalogs.Service(getClient());
        service.setBaseURL(getBaseURL());
        service.setUser(getUser());
        service.setPassword(getPassword());
        return service;
    }

    public com.meplato.mall.products.Service getProductsService() {
        com.meplato.mall.products.Service service = new com.meplato.mall.products.Service(getClient());
        service.setBaseURL(getBaseURL());
        service.setUser(getUser());
        service.setPassword(getPassword());
        return service;
    }

    public com.meplato.mall.mlt.Service getMoreLikeThisService() {
        com.meplato.mall.mlt.Service service = new com.meplato.mall.mlt.Service(getClient());
        service.setBaseURL(getBaseURL());
        service.setUser(getUser());
        service.setPassword(getPassword());
        return service;
    }

    @Before
    public void beforeTest() throws ServiceException {
    }

    @After
    public void afterTest() throws ServiceException {
    }

}
