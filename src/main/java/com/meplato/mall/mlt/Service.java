/**
 * Package mlt implements the Meplato Mall API.
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
package com.meplato.mall.mlt;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.codec.binary.Base64;

import com.meplato.mall.*;

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

	public MoreLikeThisService moreLikeThis() {
		return new MoreLikeThisService(this);
	}

	/**
	 * MoreLikeThisService: Find similar products. 
	 */
	public static class MoreLikeThisService {
		private final Service service;
		private final Map<String, Object> params = new HashMap<String, Object>();
		private final Map<String, String> headers = new HashMap<String, String>();
		private String view;

		/**
		 * Creates a new instance of MoreLikeThisService.
		 */
		public MoreLikeThisService(Service service) {
			this.service = service;
		}

		/**
		 * ISO code of the currency.
		 */
		public MoreLikeThisService currency(String currency) {
			this.params.put("currency", currency);
			return this;
		}

		/**
		 * eCl@ss code.
		 */
		public MoreLikeThisService eclass(String eclass) {
			this.params.put("eclass", eclass);
			return this;
		}

		/**
		 * Email address of the caller.
		 */
		public MoreLikeThisService email(String email) {
			this.params.put("email", email);
			return this;
		}

		/**
		 * GTIN is the global trade item number.
		 */
		public MoreLikeThisService gtin(String gtin) {
			this.params.put("gtin", gtin);
			return this;
		}

		/**
		 * Manufacturer is the manufacturer name.
		 */
		public MoreLikeThisService manufacturer(String manufacturer) {
			this.params.put("manufacturer", manufacturer);
			return this;
		}

		/**
		 * MPN is the manufacturer part number.
		 */
		public MoreLikeThisService mpn(String mpn) {
			this.params.put("mpn", mpn);
			return this;
		}

		/**
		 * Order unit.
		 */
		public MoreLikeThisService ou(String ou) {
			this.params.put("ou", ou);
			return this;
		}

		/**
		 * Pretty instructs the API to return prettified results (default false).
		 */
		public MoreLikeThisService pretty(boolean pretty) {
			this.params.put("pretty", pretty);
			return this;
		}

		/**
		 * Price is the price of the product.
		 */
		public MoreLikeThisService price(double price) {
			this.params.put("price", price);
			return this;
		}

		/**
		 * PriceQuantity of the product.
		 */
		public MoreLikeThisService priceQuantity(String priceQuantity) {
			this.params.put("priceQuantity", priceQuantity);
			return this;
		}

		/**
		 * Q defines are full text query.
		 */
		public MoreLikeThisService q(String q) {
			this.params.put("q", q);
			return this;
		}

		/**
		 * Skip specifies how many results to skip (default 0).
		 */
		public MoreLikeThisService skip(long skip) {
			this.params.put("skip", skip);
			return this;
		}

		/**
		 * SPN is the supplier part number.
		 */
		public MoreLikeThisService spn(String spn) {
			this.params.put("spn", spn);
			return this;
		}

		/**
		 * Supplier is the name of the supplier.
		 */
		public MoreLikeThisService supplier(String supplier) {
			this.params.put("supplier", supplier);
			return this;
		}

		/**
		 * Take defines how many results to return (max 100, default 20).
		 */
		public MoreLikeThisService take(long take) {
			this.params.put("take", take);
			return this;
		}

		/**
		 * UNSPSC code.
		 */
		public MoreLikeThisService unspsc(String unspsc) {
			this.params.put("unspsc", unspsc);
			return this;
		}

		/**
		 * View code.
		 */
		public MoreLikeThisService view(String view) {
			this.view = view;
			return this;
		}

		/**
		 * Execute the operation.
		 */
		public MoreLikeThisResponse execute() throws ServiceException {
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

			String uriTemplate = service.getBaseURL() + "/{view}/mlt{?q,skip,take,spn,supplier,mpn,manufacturer,gtin,price,priceQuantity,eclass,unspsc,currency,ou,email}";
			Response response = service.getClient().execute("GET", uriTemplate, params, headers, null);
			if (response != null && response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
				return response.getBodyJSON(MoreLikeThisResponse.class);
			}

			throw ServiceException.fromResponse(response);
		}
	}
}

