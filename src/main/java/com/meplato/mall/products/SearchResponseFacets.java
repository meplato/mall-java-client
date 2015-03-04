package com.meplato.mall.products;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * SearchResponseFacets returns facets of the search response.
 */
public class SearchResponseFacets {
	@SerializedName("catalogs")
	private TermFacet catalogs;
	@SerializedName("eclasses")
	private TermFacet eclasses;
	@SerializedName("manufacturers")
	private TermFacet manufacturers;
	@SerializedName("prices")
	private RangeFacet prices;
	@SerializedName("unspscs")
	private TermFacet unspscs;
	@SerializedName("vendors")
	private TermFacet vendors;

	/**
	 * Create new instance of SearchResponseFacets.
	 */
	public SearchResponseFacets() {
	}

	/**
	 * Catalog facets (if any).
	 */
	public TermFacet getCatalogs() {
		return this.catalogs;
	}

	/**
	 * Catalog facets (if any).
	 */
	public void setCatalogs(TermFacet catalogs) {
		this.catalogs = catalogs;
	}

	/**
	 * eCl@ss facets (if any).
	 */
	public TermFacet getEclasses() {
		return this.eclasses;
	}

	/**
	 * eCl@ss facets (if any).
	 */
	public void setEclasses(TermFacet eclasses) {
		this.eclasses = eclasses;
	}

	/**
	 * Manufacturer facets (if any).
	 */
	public TermFacet getManufacturers() {
		return this.manufacturers;
	}

	/**
	 * Manufacturer facets (if any).
	 */
	public void setManufacturers(TermFacet manufacturers) {
		this.manufacturers = manufacturers;
	}

	/**
	 * Price facets (if any).
	 */
	public RangeFacet getPrices() {
		return this.prices;
	}

	/**
	 * Price facets (if any).
	 */
	public void setPrices(RangeFacet prices) {
		this.prices = prices;
	}

	/**
	 * UNSPSC facets (if any).
	 */
	public TermFacet getUnspscs() {
		return this.unspscs;
	}

	/**
	 * UNSPSC facets (if any).
	 */
	public void setUnspscs(TermFacet unspscs) {
		this.unspscs = unspscs;
	}

	/**
	 * Vendor facets (if any).
	 */
	public TermFacet getVendors() {
		return this.vendors;
	}

	/**
	 * Vendor facets (if any).
	 */
	public void setVendors(TermFacet vendors) {
		this.vendors = vendors;
	}
}

