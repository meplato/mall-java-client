/*
 * Copyright (c) 2015-2016 Meplato GmbH, Switzerland.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
// THIS FILE IS AUTO-GENERATED. DO NOT MODIFY!
/**
 * Package products implements the Meplato Mall API.
 * 
 * @copyright 2014-2016 Meplato GmbH, Switzerland.
 * @author Meplato API Team <support@meplato.com>
 * @version 1.0.0
 * @license Copyright (c) 2015-2016 Meplato GmbH, Switzerland. All rights reserved.
 * @see <a href="https://developer.meplato.com/mall/#terms">Terms of Service</a>
 * @see <a href="https://developer.meplato.com/mall/">External documentation</a>
 */
package com.meplato.mall.products;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.codec.binary.Base64;

import com.meplato.mall.*;

/**
 * ProductsService is the entry point of the Meplato Mall API.
 */

public class ProductsService {
	/** API title. */
	public static String TITLE = "Meplato Mall API";
	/** API version. */
	public static String VERSION = "1.0.0";
	/** User Agent. */
	public static String USER_AGENT = "meplato-java-client/2.0";
	/** Default base URL of the API endpoints. */
	public static String BASE_URL = "https://mall.meplato.com/api/v1";
	/** RFC3339 pattern for deserializing date/time from the API. */
	public static String RFC3339 = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSSXXX";

	/** Client to use for requests. */
	private final Client client;
	/** Base URL for the API endpoints. */
	private String baseURL;
	/** User name for authentication. */
	private String user;
	/** Password for authentication. */
	private String password;

	/**
	 * Instantiate a new ProductsService.
	 *
	 * @param client the {@link Client} to use for requests.
	 */
	public ProductsService(Client client) {
		this.client = client;
		this.baseURL = BASE_URL;
	}

	/**
	 * Returns the JSON serializer for this service.
	 *
	 * @return the JSON serializer.
	 */
	public static Gson getSerializer() {
		return new GsonBuilder().setDateFormat(RFC3339).create();
	}

	/**
	 * Returns the {@link Client} for this service.
	 *
	 * @return the Client for requests.
	 */
	public Client getClient() {
		return this.client;
	}

	/**
	 * Returns the base URL for this API.
	 *
	 * @return the base URL.
	 */
	public String getBaseURL() {
		return this.baseURL;
	}

	/**
	 * Sets the base URL for this API.
	 *
	 * @param baseURL the base URL for this API.
	 */
	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}

	/**
	 * Returns the username for authentication.
	 *
	 * @return the username.
	 */
	public String getUser() {
		return this.user;
	}

	/**
	 * Sets the username for authentication.
	 *
	 * @param user the username for authentication.
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Returns the password for authentication.
	 *
	 * @return the password.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Sets the password for authentication.
	 *
	 * @param password the password for authentication.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Returns the header for HTTP Basic authentication or {@code null}.
	 *
	 * @return the HTTP Basic authentication header or {@code null}.
	 */
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

	/**
	 * Returns the {@link GetService}.
	 *
	 * @return the {@link GetService}.
	 */
	public GetService get() {
		return new GetService(this);
	}

	/**
	 * Returns the {@link ScrollService}.
	 *
	 * @return the {@link ScrollService}.
	 */
	public ScrollService scroll() {
		return new ScrollService(this);
	}

	/**
	 * Returns the {@link SearchService}.
	 *
	 * @return the {@link SearchService}.
	 */
	public SearchService search() {
		return new SearchService(this);
	}

	/**
	 * Get returns a single products.
	 */
	public static class GetService {
		private final ProductsService service;
		private final Map<String, Object> params = new HashMap<String, Object>();
		private final Map<String, String> headers = new HashMap<String, String>();
		private String view;
		private String id;

		/**
		 * Creates a new instance of GetService.
		 */
		public GetService(ProductsService service) {
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

			// Make a copy of the header parameters and set common headers, like the UA
			Map<String, String> headers = new HashMap<String, String>();
			headers.putAll(this.headers);

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
	 * Scroll is an efficient way to iterate through all products of a catalog. 
	 */
	public static class ScrollService {
		private final ProductsService service;
		private final Map<String, Object> params = new HashMap<String, Object>();
		private final Map<String, String> headers = new HashMap<String, String>();
		private int catalogId;

		/**
		 * Creates a new instance of ScrollService.
		 */
		public ScrollService(ProductsService service) {
			this.service = service;
		}

		/**
		 * Identifier of the catalog to get products from.
		 */
		public ScrollService catalogId(int catalogId) {
			this.catalogId = catalogId;
			return this;
		}

		/**
		 * PageToken for this scroll process.
		 */
		public ScrollService pageToken(String pageToken) {
			this.params.put("pageToken", pageToken);
			return this;
		}

		/**
		 * Pretty instructs the API to return prettified results (default false).
		 */
		public ScrollService pretty(boolean pretty) {
			this.params.put("pretty", pretty);
			return this;
		}

		/**
		 * Execute the operation.
		 */
		public ScrollResponse execute() throws ServiceException {
			// Make a copy of the parameters and add the path parameters to it
			Map<String, Object> params = new HashMap<String, Object>();
			params.putAll(this.params);
			params.put("catalogId", this.catalogId);

			// Make a copy of the header parameters and set common headers, like the UA
			Map<String, String> headers = new HashMap<String, String>();
			headers.putAll(this.headers);

			String authorization = service.getAuthorizationHeader();
			if (authorization != null && !authorization.isEmpty()) {
				headers.put("Authorization", authorization);
			}

			String uriTemplate = service.getBaseURL() + "/catalogs/{catalogId}/products/scroll{?pageToken,pretty}";
			Response response = service.getClient().execute("GET", uriTemplate, params, headers, null);
			if (response != null && response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
				return response.getBodyJSON(ScrollResponse.class);
			}

			throw ServiceException.fromResponse(response);
		}
	}

	/**
	 * Search for products. Do not use this method for iterating through all of the
	 * products in a catalog. Use Scroll instead. 
	 */
	public static class SearchService {
		private final ProductsService service;
		private final Map<String, Object> params = new HashMap<String, Object>();
		private final Map<String, String> headers = new HashMap<String, String>();
		private String view;

		/**
		 * Creates a new instance of SearchService.
		 */
		public SearchService(ProductsService service) {
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
		 * Instructs the API to return price range facets.
		 */
		public SearchService unspscs(boolean unspscs) {
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

			// Make a copy of the header parameters and set common headers, like the UA
			Map<String, String> headers = new HashMap<String, String>();
			headers.putAll(this.headers);

			String authorization = service.getAuthorizationHeader();
			if (authorization != null && !authorization.isEmpty()) {
				headers.put("Authorization", authorization);
			}

			String uriTemplate = service.getBaseURL() + "/{view}/products{?q,skip,take,sort,pretty,vendor,catalog,manufacturer,eclasses,unspscs}";
			Response response = service.getClient().execute("GET", uriTemplate, params, headers, null);
			if (response != null && response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
				return response.getBodyJSON(SearchResponse.class);
			}

			throw ServiceException.fromResponse(response);
		}
	}
}

