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
package com.meplato.mall.vendors;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * Vendor data.
 */
public class Vendor {
	@SerializedName("created")
	private Date created;
	@SerializedName("duns")
	private String duns;
	@SerializedName("erpNumber")
	private String erpNumber;
	@SerializedName("id")
	private long id;
	@SerializedName("kind")
	private String kind;
	@SerializedName("language")
	private String language;
	@SerializedName("mpcc")
	private String mpcc;
	@SerializedName("mpsc")
	private String mpsc;
	@SerializedName("name")
	private String name;
	@SerializedName("selfLink")
	private String selfLink;
	@SerializedName("type")
	private String type;
	@SerializedName("updated")
	private Date updated;

	/**
	 * Create new instance of Vendor.
	 */
	public Vendor() {
	}

	/**
	 * Created is the creation date and time of the vendor.
	 */
	public Date getCreated() {
		return this.created;
	}

	/**
	 * Created is the creation date and time of the vendor.
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * DUNS of the vendor.
	 */
	public String getDuns() {
		return this.duns;
	}

	/**
	 * DUNS of the vendor.
	 */
	public void setDuns(String duns) {
		this.duns = duns;
	}

	/**
	 * ERPNumber of the vendor, i.e. the number of the vendor in the system of the
	 * buyer.
	 */
	public String getErpNumber() {
		return this.erpNumber;
	}

	/**
	 * ERPNumber of the vendor, i.e. the number of the vendor in the system of the
	 * buyer.
	 */
	public void setErpNumber(String erpNumber) {
		this.erpNumber = erpNumber;
	}

	/**
	 * ID is a unique (internal) identifier of the vendor.
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * ID is a unique (internal) identifier of the vendor.
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Kind is mall#vendor,v1 for a vendor entity.
	 */
	public String getKind() {
		return this.kind;
	}

	/**
	 * Kind is mall#vendor,v1 for a vendor entity.
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}

	/**
	 * Language that the vendor typically uses for communication.
	 */
	public String getLanguage() {
		return this.language;
	}

	/**
	 * Language that the vendor typically uses for communication.
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * MPCC of the vendor, i.e. the unique Meplato company code.
	 */
	public String getMpcc() {
		return this.mpcc;
	}

	/**
	 * MPCC of the vendor, i.e. the unique Meplato company code.
	 */
	public void setMpcc(String mpcc) {
		this.mpcc = mpcc;
	}

	/**
	 * MPSC of the vendor, i.e. the Meplato supplier code.
	 */
	public String getMpsc() {
		return this.mpsc;
	}

	/**
	 * MPSC of the vendor, i.e. the Meplato supplier code.
	 */
	public void setMpsc(String mpsc) {
		this.mpsc = mpsc;
	}

	/**
	 * Name of the vendor.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Name of the vendor.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * URL to the vendor details.
	 */
	public String getSelfLink() {
		return this.selfLink;
	}

	/**
	 * URL to the vendor details.
	 */
	public void setSelfLink(String selfLink) {
		this.selfLink = selfLink;
	}

	/**
	 * Vendor type (default: default).
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Vendor type (default: default).
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Updated is the last modification date and time of the vendor.
	 */
	public Date getUpdated() {
		return this.updated;
	}

	/**
	 * Updated is the last modification date and time of the vendor.
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
}

