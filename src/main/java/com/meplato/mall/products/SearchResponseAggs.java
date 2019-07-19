/*
 * Copyright (c) 2013-present Meplato GmbH.
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
package com.meplato.mall.products;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * SearchResponseAggs returns facets of the search response.
 */
public class SearchResponseAggs {
	@SerializedName("catalogs")
	private TermBucket[] catalogs;
	@SerializedName("eclasses")
	private TermNameBucket[] eclasses;
	@SerializedName("manufacturers")
	private TermBucket[] manufacturers;
	@SerializedName("prices")
	private RangeBucket[] prices;
	@SerializedName("unspscs")
	private TermNameBucket[] unspscs;
	@SerializedName("vendors")
	private TermBucket[] vendors;

	/**
	 * Create new instance of SearchResponseAggs.
	 */
	public SearchResponseAggs() {
	}

	/**
	 * Catalog facets (if any).
	 */
	public TermBucket[] getCatalogs() {
		return this.catalogs;
	}

	/**
	 * Catalog facets (if any).
	 */
	public void setCatalogs(TermBucket[] catalogs) {
		this.catalogs = catalogs;
	}

	/**
	 * eCl@ss facets (if any).
	 */
	public TermNameBucket[] getEclasses() {
		return this.eclasses;
	}

	/**
	 * eCl@ss facets (if any).
	 */
	public void setEclasses(TermNameBucket[] eclasses) {
		this.eclasses = eclasses;
	}

	/**
	 * Manufacturer facets (if any).
	 */
	public TermBucket[] getManufacturers() {
		return this.manufacturers;
	}

	/**
	 * Manufacturer facets (if any).
	 */
	public void setManufacturers(TermBucket[] manufacturers) {
		this.manufacturers = manufacturers;
	}

	/**
	 * Price facets (if any).
	 */
	public RangeBucket[] getPrices() {
		return this.prices;
	}

	/**
	 * Price facets (if any).
	 */
	public void setPrices(RangeBucket[] prices) {
		this.prices = prices;
	}

	/**
	 * UNSPSC facets (if any).
	 */
	public TermNameBucket[] getUnspscs() {
		return this.unspscs;
	}

	/**
	 * UNSPSC facets (if any).
	 */
	public void setUnspscs(TermNameBucket[] unspscs) {
		this.unspscs = unspscs;
	}

	/**
	 * Vendor facets (if any).
	 */
	public TermBucket[] getVendors() {
		return this.vendors;
	}

	/**
	 * Vendor facets (if any).
	 */
	public void setVendors(TermBucket[] vendors) {
		this.vendors = vendors;
	}
}

