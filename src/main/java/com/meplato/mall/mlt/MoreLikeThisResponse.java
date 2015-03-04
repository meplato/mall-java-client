package com.meplato.mall.mlt;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * MoreLikeThisResponse is a partial listing of similar products.
 */
public class MoreLikeThisResponse {
	@SerializedName("items")
	private Product[] items;
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
	 * Create new instance of MoreLikeThisResponse.
	 */
	public MoreLikeThisResponse() {
	}

	/**
	 * Items is the slice of products of this result.
	 */
	public Product[] getItems() {
		return this.items;
	}

	/**
	 * Items is the slice of products of this result.
	 */
	public void setItems(Product[] items) {
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
	 * Kind is store#products/search for this kind of response.
	 */
	public String getKind() {
		return this.kind;
	}

	/**
	 * Kind is store#products/search for this kind of response.
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}

	/**
	 * NextLink returns the URL to the next slice of products (if any).
	 */
	public String getNextLink() {
		return this.nextLink;
	}

	/**
	 * NextLink returns the URL to the next slice of products (if any).
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
	 * StartIndex describes the index of the first product in this resultset.
	 */
	public long getStartIndex() {
		return this.startIndex;
	}

	/**
	 * StartIndex describes the index of the first product in this resultset.
	 */
	public void setStartIndex(long startIndex) {
		this.startIndex = startIndex;
	}

	/**
	 * TotalItems describes the total number of products found.
	 */
	public long getTotalItems() {
		return this.totalItems;
	}

	/**
	 * TotalItems describes the total number of products found.
	 */
	public void setTotalItems(long totalItems) {
		this.totalItems = totalItems;
	}
}

