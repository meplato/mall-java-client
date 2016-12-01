package com.meplato.mall;

import okhttp3.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * OkHttpClientTest tests the OkHttp client.
 */
public class OkHttpClientTest extends BaseTest {
    private okhttp3.OkHttpClient httpClient;

    @Before
    public void beforeTest() throws Exception {
        this.httpClient = new okhttp3.OkHttpClient.Builder().build();
    }

    @Test
    public void testPing() throws ServiceException {
        OkHttpClient client = new OkHttpClient(this.httpClient);
        Map<String, Object> params = new HashMap<String, Object>();
        Map<String, String> headers = new HashMap<String, String>();
        Response response = client.execute("HEAD", "https://mall.meplato.com/api/v1", params, headers, null);
        assertNotNull(response);
        assertEquals(200, response.getStatusCode());
    }
}
