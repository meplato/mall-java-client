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
package com.meplato.mall.catalogs;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * SearchResponse is a partial listing of catalogs.
 */
public class SearchResponse {
	@SerializedName("items")
	private Catalog[] items;
	@SerializedName("itemsPerPage")
	private long itemsPerPage;
	@SerializedName("kind")
	private String kind;
	@SerializedName("nextLink")
	private String nextLink;
	@SerializedName("selfLink")
	private String selfLink;
	@SerializedName("startIndex")
	private long startIndex;
	@SerializedName("totalItems")
	private long totalItems;

	/**
	 * Create new instance of SearchResponse.
	 */
	public SearchResponse() {
	}

	/**
	 * Items is the slice of catalogs of this result.
	 */
	public Catalog[] getItems() {
		return this.items;
	}

	/**
	 * Items is the slice of catalogs of this result.
	 */
	public void setItems(Catalog[] items) {
		this.items = items;
	}

	/**
	 * ItemsPerPage describes the number of results per page.
	 */
	public long getItemsPerPage() {
		return this.itemsPerPage;
	}

	/**
	 * ItemsPerPage describes the number of results per page.
	 */
	public void setItemsPerPage(long itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	/**
	 * Kind is store#catalogs,v1 for this kind of response.
	 */
	public String getKind() {
		return this.kind;
	}

	/**
	 * Kind is store#catalogs,v1 for this kind of response.
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}

	/**
	 * NextLink returns the URL to the next slice of catalogs (if any).
	 */
	public String getNextLink() {
		return this.nextLink;
	}

	/**
	 * NextLink returns the URL to the next slice of catalogs (if any).
	 */
	public void setNextLink(String nextLink) {
		this.nextLink = nextLink;
	}

	/**
	 * SelfLink returns the URL to this page.
	 */
	public String getSelfLink() {
		return this.selfLink;
	}

	/**
	 * SelfLink returns the URL to this page.
	 */
	public void setSelfLink(String selfLink) {
		this.selfLink = selfLink;
	}

	/**
	 * StartIndex describes the index of the first catalog in this resultset.
	 */
	public long getStartIndex() {
		return this.startIndex;
	}

	/**
	 * StartIndex describes the index of the first catalog in this resultset.
	 */
	public void setStartIndex(long startIndex) {
		this.startIndex = startIndex;
	}

	/**
	 * TotalItems describes the total number of catalogs found.
	 */
	public long getTotalItems() {
		return this.totalItems;
	}

	/**
	 * TotalItems describes the total number of catalogs found.
	 */
	public void setTotalItems(long totalItems) {
		this.totalItems = totalItems;
	}
}

