/**
 * Package catalogs implements the Meplato Mall API.
 *
 * @copyright 2014-2015 Meplato GmbH, Switzerland. All rights reserved.
 *
 * @author Meplato API Team <support@meplato.com>
 *
 * @version 1.0.0.alpha1
 *
 * @license Copyright (c) 2015 Meplato GmbH, Switzerland. All rights reserved.
 *
 * @see <a href="https://developer.meplato.com/mall/#terms">Terms of Service</a>
 *
 * @see <a href="https://developer.meplato.com/mall/">External documentation</a>
 */
package com.meplato.mall.catalogs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.meplato.mall.Client;
import com.meplato.mall.Response;
import com.meplato.mall.ServiceException;
import org.apache.commons.codec.binary.Base64;

import java.util.HashMap;
import java.util.Map;

public class Service {
    public static String TITLE = "Meplato Mall API";
    public static String VERSION = "1.0.0.alpha1";
    public static String USER_AGENT = "meplato-api-java-version/1.0.0";
    public static String BASE_URL = "https://mall.meplato.com/api/v1";
    public static String RFC3339 = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSSXXX";

    private final Client client;
    private String baseURL;
    private String user;
    private String password;

    public Service(Client client) {
        this.client = client;
        this.baseURL = BASE_URL;
    }

    public static Gson getSerializer() {
        return new GsonBuilder().setDateFormat(RFC3339).create();
    }

    public Client getClient() {
        return this.client;
    }

    public String getBaseURL() {
        return this.baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthorizationHeader() {
        String user = getUser();
        String password = getPassword();
        if ((user != null && !user.isEmpty()) || (password != null && !password.isEmpty())) {
            String userPass = "";
            if (user != null) {
                userPass = user;
            }
            userPass = userPass + ":";
            if (password != null) {
                userPass = userPass + password;
            }
            String credentials = Base64.encodeBase64String(userPass.getBytes());
            return "Basic " + credentials;
        }
        return null;
    }

    public SearchService search() {
        return new SearchService(this);
    }

    public GetService get() {
        return new GetService(this);
    }

    /**
     * SearchService: Search for catalogs.
     */
    public static class SearchService {
        private final Service service;
        private final Map<String, Object> params = new HashMap<String, Object>();
        private final Map<String, String> headers = new HashMap<String, String>();

        /**
         * Creates a new instance of SearchService.
         */
        public SearchService(Service service) {
            this.service = service;
        }

        /**
         * Pretty instructs the API to return prettified results (default false).
         */
        public SearchService pretty(boolean pretty) {
            this.params.put("pretty", pretty);
            return this;
        }

        /**
         * Q defines keywords to search for in the catalog name.
         */
        public SearchService q(String q) {
            this.params.put("q", q);
            return this;
        }

        /**
         * Skip specifies how many catalogs to skip (default 0).
         */
        public SearchService skip(long skip) {
            this.params.put("skip", skip);
            return this;
        }

        /**
         * Sort columns, separated by a comma. Preprend with a minus sign (-) to get
         * descending sort order.
         */
        public SearchService sort(String sort) {
            this.params.put("sort", sort);
            return this;
        }

        /**
         * Take defines how many catalogs to return (max 100, default 20).
         */
        public SearchService take(long take) {
            this.params.put("take", take);
            return this;
        }

        /**
         * Execute the operation.
         */
        public SearchResponse execute() throws ServiceException {
            // Make a copy of the parameters and add the path parameters to it
            Map<String, Object> params = new HashMap<String, Object>();
            params.putAll(this.params);

            // Make a copy of the header parameters and set Content-Type and UA
            Map<String, String> headers = new HashMap<String, String>();
            headers.putAll(this.headers);
            headers.put("Content-Type", "application/json");
            headers.put("User-Agent", Service.USER_AGENT);

            String authorization = service.getAuthorizationHeader();
            if (authorization != null && !authorization.isEmpty()) {
                headers.put("Authorization", authorization);
            }

            String uriTemplate = service.getBaseURL() + "/catalogs{?q,skip,take,sort,pretty}";
            Response response = service.getClient().execute("GET", uriTemplate, params, headers, null);
            if (response != null && response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
                return response.getBodyJSON(SearchResponse.class);
            }

            throw ServiceException.fromResponse(response);
        }
    }

    /**
     * GetService: Get returns a single catalog.
     */
    public static class GetService {
        private final Service service;
        private final Map<String, Object> params = new HashMap<String, Object>();
        private final Map<String, String> headers = new HashMap<String, String>();
        private long id;

        /**
         * Creates a new instance of GetService.
         */
        public GetService(Service service) {
            this.service = service;
        }

        /**
         * ID of the catalog to retrieve.
         */
        public GetService id(long id) {
            this.id = id;
            return this;
        }

        /**
         * Execute the operation.
         */
        public Catalog execute() throws ServiceException {
            // Make a copy of the parameters and add the path parameters to it
            Map<String, Object> params = new HashMap<String, Object>();
            params.putAll(this.params);
            params.put("id", this.id);

            // Make a copy of the header parameters and set Content-Type and UA
            Map<String, String> headers = new HashMap<String, String>();
            headers.putAll(this.headers);
            headers.put("Content-Type", "application/json");
            headers.put("User-Agent", Service.USER_AGENT);

            String authorization = service.getAuthorizationHeader();
            if (authorization != null && !authorization.isEmpty()) {
                headers.put("Authorization", authorization);
            }

            String uriTemplate = service.getBaseURL() + "/catalogs/{id}";
            Response response = service.getClient().execute("GET", uriTemplate, params, headers, null);
            if (response != null && response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
                return response.getBodyJSON(Catalog.class);
            }

            throw ServiceException.fromResponse(response);
        }
    }
}

