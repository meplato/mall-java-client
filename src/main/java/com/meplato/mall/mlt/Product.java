/*
 * Copyright (c) 2015 Meplato GmbH, Switzerland.
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
package com.meplato.mall.mlt;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * Product is a good or service in a catalog.
 */
public class Product {
	@SerializedName("categories")
	private String[] categories;
	@SerializedName("contentUnit")
	private String contentUnit;
	@SerializedName("cuPerOu")
	private double cuPerOu;
	@SerializedName("currency")
	private String currency;
	@SerializedName("dataSheetLink")
	private String dataSheetLink;
	@SerializedName("description")
	private String description;
	@SerializedName("eclasses")
	private String[] eclasses;
	@SerializedName("gtins")
	private String[] gtins;
	@SerializedName("id")
	private String id;
	@SerializedName("imageLink")
	private String imageLink;
	@SerializedName("keywords")
	private String[] keywords;
	@SerializedName("kind")
	private String kind;
	@SerializedName("mpn")
	private String mpn;
	@SerializedName("orderUnit")
	private String orderUnit;
	@SerializedName("price")
	private double price;
	@SerializedName("priceQuantity")
	private double priceQuantity;
	@SerializedName("safetySheetLink")
	private String safetySheetLink;
	@SerializedName("scalePrices")
	private ScalePrice[] scalePrices;
	@SerializedName("selfLink")
	private String selfLink;
	@SerializedName("spn")
	private String spn;
	@SerializedName("thumbnailLink")
	private String thumbnailLink;
	@SerializedName("title")
	private String title;
	@SerializedName("unspscs")
	private String[] unspscs;
	@SerializedName("vendor")
	private String vendor;
	@SerializedName("vendorErpNumber")
	private String vendorErpNumber;

	/**
	 * Create new instance of Product.
	 */
	public Product() {
	}

	/**
	 * Categories is a list of (supplier-specific) category names the product
	 * belongs to.
	 */
	public String[] getCategories() {
		return this.categories;
	}

	/**
	 * Categories is a list of (supplier-specific) category names the product
	 * belongs to.
	 */
	public void setCategories(String[] categories) {
		this.categories = categories;
	}

	/**
	 * ContentUnit is the content unit of the product, a 3-character ISO code
	 * (usually project-specific).
	 */
	public String getContentUnit() {
		return this.contentUnit;
	}

	/**
	 * ContentUnit is the content unit of the product, a 3-character ISO code
	 * (usually project-specific).
	 */
	public void setContentUnit(String contentUnit) {
		this.contentUnit = contentUnit;
	}

	/**
	 * CuPerOu describes the number of content units per order unit, e.g. the 12 in
	 * '1 case contains 12 bottles'.
	 */
	public double getCuPerOu() {
		return this.cuPerOu;
	}

	/**
	 * CuPerOu describes the number of content units per order unit, e.g. the 12 in
	 * '1 case contains 12 bottles'.
	 */
	public void setCuPerOu(double cuPerOu) {
		this.cuPerOu = cuPerOu;
	}

	/**
	 * Currency is the ISO code of the currency.
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Currency is the ISO code of the currency.
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * DataSheetLink is a URL to the datasheet (if any).
	 */
	public String getDataSheetLink() {
		return this.dataSheetLink;
	}

	/**
	 * DataSheetLink is a URL to the datasheet (if any).
	 */
	public void setDataSheetLink(String dataSheetLink) {
		this.dataSheetLink = dataSheetLink;
	}

	/**
	 * Description of the product.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Description of the product.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Eclasses is a list of eCl@ss categories the product belongs to.
	 */
	public String[] getEclasses() {
		return this.eclasses;
	}

	/**
	 * Eclasses is a list of eCl@ss categories the product belongs to.
	 */
	public void setEclasses(String[] eclasses) {
		this.eclasses = eclasses;
	}

	/**
	 * GTINs is the list of GTIN part numbers.
	 */
	public String[] getGtins() {
		return this.gtins;
	}

	/**
	 * GTINs is the list of GTIN part numbers.
	 */
	public void setGtins(String[] gtins) {
		this.gtins = gtins;
	}

	/**
	 * ID is a unique (internal) identifier of the product.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * ID is a unique (internal) identifier of the product.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * ImageLink is a URL to the image (if any).
	 */
	public String getImageLink() {
		return this.imageLink;
	}

	/**
	 * ImageLink is a URL to the image (if any).
	 */
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	/**
	 * Keywords is a list of aliases for the product.
	 */
	public String[] getKeywords() {
		return this.keywords;
	}

	/**
	 * Keywords is a list of aliases for the product.
	 */
	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}

	/**
	 * Kind is store#product for a product entity.
	 */
	public String getKind() {
		return this.kind;
	}

	/**
	 * Kind is store#product for a product entity.
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}

	/**
	 * MPN is the manufacturer part number.
	 */
	public String getMpn() {
		return this.mpn;
	}

	/**
	 * MPN is the manufacturer part number.
	 */
	public void setMpn(String mpn) {
		this.mpn = mpn;
	}

	/**
	 * OrderUnit is the order unit of the product, a 3-character ISO code (usually
	 * project-specific).
	 */
	public String getOrderUnit() {
		return this.orderUnit;
	}

	/**
	 * OrderUnit is the order unit of the product, a 3-character ISO code (usually
	 * project-specific).
	 */
	public void setOrderUnit(String orderUnit) {
		this.orderUnit = orderUnit;
	}

	/**
	 * Price is the net price (per order unit) of the product for the end-user.
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Price is the net price (per order unit) of the product for the end-user.
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * PriceQuantity is the quantity for which the price is specified (default:
	 * 1.0).
	 */
	public double getPriceQuantity() {
		return this.priceQuantity;
	}

	/**
	 * PriceQuantity is the quantity for which the price is specified (default:
	 * 1.0).
	 */
	public void setPriceQuantity(double priceQuantity) {
		this.priceQuantity = priceQuantity;
	}

	/**
	 * SafetySheetLink is a URL to the safety datasheet (if any).
	 */
	public String getSafetySheetLink() {
		return this.safetySheetLink;
	}

	/**
	 * SafetySheetLink is a URL to the safety datasheet (if any).
	 */
	public void setSafetySheetLink(String safetySheetLink) {
		this.safetySheetLink = safetySheetLink;
	}

	/**
	 * ScalePrices can be used when the price of the product is dependent on the
	 * ordered quantity.
	 */
	public ScalePrice[] getScalePrices() {
		return this.scalePrices;
	}

	/**
	 * ScalePrices can be used when the price of the product is dependent on the
	 * ordered quantity.
	 */
	public void setScalePrices(ScalePrice[] scalePrices) {
		this.scalePrices = scalePrices;
	}

	/**
	 * URL to this page.
	 */
	public String getSelfLink() {
		return this.selfLink;
	}

	/**
	 * URL to this page.
	 */
	public void setSelfLink(String selfLink) {
		this.selfLink = selfLink;
	}

	/**
	 * SPN is the supplier part number.
	 */
	public String getSpn() {
		return this.spn;
	}

	/**
	 * SPN is the supplier part number.
	 */
	public void setSpn(String spn) {
		this.spn = spn;
	}

	/**
	 * ThumbnailLink is a URL to the thumbnail image (if any).
	 */
	public String getThumbnailLink() {
		return this.thumbnailLink;
	}

	/**
	 * ThumbnailLink is a URL to the thumbnail image (if any).
	 */
	public void setThumbnailLink(String thumbnailLink) {
		this.thumbnailLink = thumbnailLink;
	}

	/**
	 * Name of the product.
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Name of the product.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Unspscs is a list of UNSPSC categories the product belongs to.
	 */
	public String[] getUnspscs() {
		return this.unspscs;
	}

	/**
	 * Unspscs is a list of UNSPSC categories the product belongs to.
	 */
	public void setUnspscs(String[] unspscs) {
		this.unspscs = unspscs;
	}

	/**
	 * Vendor is the name of the vendor.
	 */
	public String getVendor() {
		return this.vendor;
	}

	/**
	 * Vendor is the name of the vendor.
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	/**
	 * VendorERPNumber is the number of the vendor in the ERP system.
	 */
	public String getVendorErpNumber() {
		return this.vendorErpNumber;
	}

	/**
	 * VendorERPNumber is the number of the vendor in the ERP system.
	 */
	public void setVendorErpNumber(String vendorErpNumber) {
		this.vendorErpNumber = vendorErpNumber;
	}
}

