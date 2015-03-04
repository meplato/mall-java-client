package com.meplato.mall;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ServiceTest extends BaseTest {

    @Test
    public void testGetClient() throws Exception {
        assertNotNull(getClient());
    }

    /*
    @Test
    public void testGsonDateSerialization() throws Exception {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSSXXX").create();
        //Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateRFC3339TypeAdapter()).create();
        String date = "2014-12-23T19:43:43Z";
        Date test = gson.fromJson(date, Date.class);
        assertEquals("abc", test);
    }

    @Test
    public void testGsonDateTimeSerialization() throws Exception {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
        String date = "2014-12-23T19:43:43+01:00";
        DateTime test = gson.fromJson(date, DateTime.class);
        assertEquals("abc", test);
    }
    */
}
