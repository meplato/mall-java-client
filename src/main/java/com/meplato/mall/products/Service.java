/**
 * Package products implements the Meplato Mall API.
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
package com.meplato.mall.products;

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

    public GetService get() {
        return new GetService(this);
    }

    public SearchService search() {
        return new SearchService(this);
    }

    /**
     * GetService: Get returns a single products.
     */
    public static class GetService {
        private final Service service;
        private final Map<String, Object> params = new HashMap<String, Object>();
        private final Map<String, String> headers = new HashMap<String, String>();
        private String view;
        private String id;

        /**
         * Creates a new instance of GetService.
         */
        public GetService(Service service) {
            this.service = service;
        }

        /**
         * IDs of the product to get.
         */
        public GetService id(String id) {
            this.id = id;
            return this;
        }

        /**
         * View code.
         */
        public GetService view(String view) {
            this.view = view;
            return this;
        }

        /**
         * Execute the operation.
         */
        public Product execute() throws ServiceException {
            // Make a copy of the parameters and add the path parameters to it
            Map<String, Object> params = new HashMap<String, Object>();
            params.putAll(this.params);
            params.put("id", this.id);
            params.put("view", this.view);

            // Make a copy of the header parameters and set Content-Type and UA
            Map<String, String> headers = new HashMap<String, String>();
            headers.putAll(this.headers);
            headers.put("Content-Type", "application/json");
            headers.put("User-Agent", Service.USER_AGENT);

            String authorization = service.getAuthorizationHeader();
            if (authorization != null && !authorization.isEmpty()) {
                headers.put("Authorization", authorization);
            }

            String uriTemplate = service.getBaseURL() + "/{view}/products/{id}";
            Response response = service.getClient().execute("GET", uriTemplate, params, headers, null);
            if (response != null && response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
                return response.getBodyJSON(Product.class);
            }

            throw ServiceException.fromResponse(response);
        }
    }

    /**
     * SearchService: Search for products. Do not use this method for iterating
     * through all of the products in a catalog.
     */
    public static class SearchService {
        private final Service service;
        private final Map<String, Object> params = new HashMap<String, Object>();
        private final Map<String, String> headers = new HashMap<String, String>();
        private String view;

        /**
         * Creates a new instance of SearchService.
         */
        public SearchService(Service service) {
            this.service = service;
        }

        /**
         * Catalog limits results to the given catalog.
         */
        public SearchService catalog(String catalog) {
            this.params.put("catalog", catalog);
            return this;
        }

        /**
         * Eclasses limits results to the given eCl@ss codes.
         */
        public SearchService eclasses(String eclasses) {
            this.params.put("eclasses", eclasses);
            return this;
        }

        /**
         * Instructs the API to return catalog facets.
         */
        public SearchService f_catalogs(boolean f_catalogs) {
            this.params.put("f_catalogs", f_catalogs);
            return this;
        }

        /**
         * Describes the number of catalog facets to return (default is 10).
         */
        public SearchService f_catalogs_size(int f_catalogs_size) {
            this.params.put("f_catalogs_size", f_catalogs_size);
            return this;
        }

        /**
         * Instructs the API to return eCl@ss facets.
         */
        public SearchService f_eclasses(boolean f_eclasses) {
            this.params.put("f_eclasses", f_eclasses);
            return this;
        }

        /**
         * Describes the number of eCl@ss facets to return (default is 10).
         */
        public SearchService f_eclasses_size(int f_eclasses_size) {
            this.params.put("f_eclasses_size", f_eclasses_size);
            return this;
        }

        /**
         * Instructs the API to return manufacturer facets.
         */
        public SearchService f_manufacturers(boolean f_manufacturers) {
            this.params.put("f_manufacturers", f_manufacturers);
            return this;
        }

        /**
         * Describes the number of manufacturer facets to return (default is 10).
         */
        public SearchService f_manufacturers_size(int f_manufacturers_size) {
            this.params.put("f_manufacturers_size", f_manufacturers_size);
            return this;
        }

        /**
         * Instructs the API to return price range facets.
         */
        public SearchService f_prices(boolean f_prices) {
            this.params.put("f_prices", f_prices);
            return this;
        }

        /**
         * Instructs the API to return UNSPSC facets.
         */
        public SearchService f_unspscs(boolean f_unspscs) {
            this.params.put("f_unspscs", f_unspscs);
            return this;
        }

        /**
         * Describes the number of UNSPSC facets to return (default is 10).
         */
        public SearchService f_unspscs_size(int f_unspscs_size) {
            this.params.put("f_unspscs_size", f_unspscs_size);
            return this;
        }

        /**
         * Instructs the API to return vendor facets.
         */
        public SearchService f_vendors(boolean f_vendors) {
            this.params.put("f_vendors", f_vendors);
            return this;
        }

        /**
         * Describes the number of vendor facets to return (default is 10).
         */
        public SearchService f_vendors_size(int f_vendors_size) {
            this.params.put("f_vendors_size", f_vendors_size);
            return this;
        }

        /**
         * Manufacturer limits results to the given manufacturer.
         */
        public SearchService manufacturer(String manufacturer) {
            this.params.put("manufacturer", manufacturer);
            return this;
        }

        /**
         * Pretty instructs the API to return prettified results (default false).
         */
        public SearchService pretty(boolean pretty) {
            this.params.put("pretty", pretty);
            return this;
        }

        /**
         * Q defines are full text query.
         */
        public SearchService q(String q) {
            this.params.put("q", q);
            return this;
        }

        /**
         * Skip specifies how many products to skip (default 0).
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
         * Take defines how many products to return (max 100, default 20).
         */
        public SearchService take(long take) {
            this.params.put("take", take);
            return this;
        }

        /**
         * Unspscs limits results to the given UNSPSC codes.
         */
        public SearchService unspscs(String unspscs) {
            this.params.put("unspscs", unspscs);
            return this;
        }

        /**
         * Vendor limits results to the given vendor.
         */
        public SearchService vendor(String vendor) {
            this.params.put("vendor", vendor);
            return this;
        }

        /**
         * View code.
         */
        public SearchService view(String view) {
            this.view = view;
            return this;
        }

        /**
         * Execute the operation.
         */
        public SearchResponse execute() throws ServiceException {
            // Make a copy of the parameters and add the path parameters to it
            Map<String, Object> params = new HashMap<String, Object>();
            params.putAll(this.params);
            params.put("view", this.view);

            // Make a copy of the header parameters and set Content-Type and UA
            Map<String, String> headers = new HashMap<String, String>();
            headers.putAll(this.headers);
            headers.put("Content-Type", "application/json");
            headers.put("User-Agent", Service.USER_AGENT);

            String authorization = service.getAuthorizationHeader();
            if (authorization != null && !authorization.isEmpty()) {
                headers.put("Authorization", authorization);
            }

            String uriTemplate = service.getBaseURL() + "/{view}/products{?q,skip,take,sort,pretty,vendor,catalog,manufacturer,eclasses,unspscs,f_vendors,f_vendors_size,f_catalogs,f_catalogs_size,f_manufacturers,f_manufacturers_size,f_eclasses,f_eclasses_size,f_unspscs,f_unspscs_size,f_prices}";
            Response response = service.getClient().execute("GET", uriTemplate, params, headers, null);
            if (response != null && response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
                return response.getBodyJSON(SearchResponse.class);
            }

            throw ServiceException.fromResponse(response);
        }
    }
}

