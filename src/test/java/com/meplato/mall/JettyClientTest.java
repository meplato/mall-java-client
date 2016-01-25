package com.meplato.mall;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * JettyClientTest tests JettyClient.
 */
public class JettyClientTest extends BaseTest {
    private HttpClient httpClient;

    @Before
    public void beforeTest() throws ServiceException, Exception {
        SslContextFactory sslContextFactory = new SslContextFactory();
        this.httpClient = new HttpClient(sslContextFactory);
        this.httpClient.start();
    }

    @After
    public void afterTest() throws ServiceException, Exception {
        if (this.httpClient != null && this.httpClient.isStarted()) {
            this.httpClient.stop();
        }
    }

    @Test
    public void testPing() throws ServiceException {
        JettyHttpClient client = new JettyHttpClient(this.httpClient);
        Map<String, Object> params = new HashMap<String, Object>();
        Map<String, String> headers = new HashMap<String, String>();
        Response response = client.execute("HEAD", "https://mall.meplato.com/api/v1", params, headers, null);
        assertNotNull(response);
        assertEquals(200, response.getStatusCode());
    }
}
