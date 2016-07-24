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
package com.meplato.mall.catalogs;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * Catalog data.
 */
public class Catalog {
	@SerializedName("catalogManaged")
	private Boolean catalogManaged;
	@SerializedName("created")
	private Date created;
	@SerializedName("currency")
	private String currency;
	@SerializedName("hubUrl")
	private String hubUrl;
	@SerializedName("id")
	private long id;
	@SerializedName("isEffective")
	private boolean isEffective;
	@SerializedName("isExpired")
	private boolean isExpired;
	@SerializedName("kind")
	private String kind;
	@SerializedName("language")
	private String language;
	@SerializedName("lastSyncAt")
	private Date lastSyncAt;
	@SerializedName("lockedForDownload")
	private boolean lockedForDownload;
	@SerializedName("ociUrl")
	private String ociUrl;
	@SerializedName("sageContract")
	private String sageContract;
	@SerializedName("sageNumber")
	private String sageNumber;
	@SerializedName("selfLink")
	private String selfLink;
	@SerializedName("skipWorkArea")
	private boolean skipWorkArea;
	@SerializedName("syncVersion")
	private long syncVersion;
	@SerializedName("title")
	private String title;
	@SerializedName("updated")
	private Date updated;
	@SerializedName("validFrom")
	private String validFrom;
	@SerializedName("validUntil")
	private String validUntil;
	@SerializedName("vendor")
	private Vendor vendor;

	/**
	 * Create new instance of Catalog.
	 */
	public Catalog() {
	}

	/**
	 * Indicates whether the catalog is 'catalog managed' according to SAP OCI 5.
	 */
	public Boolean getCatalogManaged() {
		return this.catalogManaged;
	}

	/**
	 * Indicates whether the catalog is 'catalog managed' according to SAP OCI 5.
	 */
	public void setCatalogManaged(Boolean catalogManaged) {
		this.catalogManaged = catalogManaged;
	}

	/**
	 * Created is the creation date and time of the catalog.
	 */
	public Date getCreated() {
		return this.created;
	}

	/**
	 * Created is the creation date and time of the catalog.
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * Currency code.
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Currency code.
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * HubURL represents the Meplato Hub endpoint for this catalog.
	 */
	public String getHubUrl() {
		return this.hubUrl;
	}

	/**
	 * HubURL represents the Meplato Hub endpoint for this catalog.
	 */
	public void setHubUrl(String hubUrl) {
		this.hubUrl = hubUrl;
	}

	/**
	 * ID is a unique (internal) identifier of the catalog.
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * ID is a unique (internal) identifier of the catalog.
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Indicates whether the catalog is effective as of now.
	 */
	public boolean isIsEffective() {
		return this.isEffective;
	}

	/**
	 * Indicates whether the catalog is effective as of now.
	 */
	public void setIsEffective(boolean isEffective) {
		this.isEffective = isEffective;
	}

	/**
	 * Indicates whether the catalog is expired.
	 */
	public boolean isIsExpired() {
		return this.isExpired;
	}

	/**
	 * Indicates whether the catalog is expired.
	 */
	public void setIsExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}

	/**
	 * Kind is mall#catalog,v1 for a catalog entity.
	 */
	public String getKind() {
		return this.kind;
	}

	/**
	 * Kind is mall#catalog,v1 for a catalog entity.
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}

	/**
	 * Language code.
	 */
	public String getLanguage() {
		return this.language;
	}

	/**
	 * Language code.
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Date/time when the catalog has last been synchronized.
	 */
	public Date getLastSyncAt() {
		return this.lastSyncAt;
	}

	/**
	 * Date/time when the catalog has last been synchronized.
	 */
	public void setLastSyncAt(Date lastSyncAt) {
		this.lastSyncAt = lastSyncAt;
	}

	/**
	 * LockedForDownload indicates whether a catalog is available for download.
	 */
	public boolean isLockedForDownload() {
		return this.lockedForDownload;
	}

	/**
	 * LockedForDownload indicates whether a catalog is available for download.
	 */
	public void setLockedForDownload(boolean lockedForDownload) {
		this.lockedForDownload = lockedForDownload;
	}

	/**
	 * OciURL represents the OCI endpoint the supplier specified for this catalog,
	 * including all mandatory parameters in the query string.
	 */
	public String getOciUrl() {
		return this.ociUrl;
	}

	/**
	 * OciURL represents the OCI endpoint the supplier specified for this catalog,
	 * including all mandatory parameters in the query string.
	 */
	public void setOciUrl(String ociUrl) {
		this.ociUrl = ociUrl;
	}

	/**
	 * SageContract represents the Meplato-internal contract number for the catalog.
	 */
	public String getSageContract() {
		return this.sageContract;
	}

	/**
	 * SageContract represents the Meplato-internal contract number for the catalog.
	 */
	public void setSageContract(String sageContract) {
		this.sageContract = sageContract;
	}

	/**
	 * SageNumber represents the Meplato-internal number for the vendor of the
	 * catalog.
	 */
	public String getSageNumber() {
		return this.sageNumber;
	}

	/**
	 * SageNumber represents the Meplato-internal number for the vendor of the
	 * catalog.
	 */
	public void setSageNumber(String sageNumber) {
		this.sageNumber = sageNumber;
	}

	/**
	 * URL to the catalog details.
	 */
	public String getSelfLink() {
		return this.selfLink;
	}

	/**
	 * URL to the catalog details.
	 */
	public void setSelfLink(String selfLink) {
		this.selfLink = selfLink;
	}

	/**
	 * SkipWorkArea indicates whether this catalog will skip the staging area in
	 * Mall.
	 */
	public boolean isSkipWorkArea() {
		return this.skipWorkArea;
	}

	/**
	 * SkipWorkArea indicates whether this catalog will skip the staging area in
	 * Mall.
	 */
	public void setSkipWorkArea(boolean skipWorkArea) {
		this.skipWorkArea = skipWorkArea;
	}

	/**
	 * Current synchronization version.
	 */
	public long getSyncVersion() {
		return this.syncVersion;
	}

	/**
	 * Current synchronization version.
	 */
	public void setSyncVersion(long syncVersion) {
		this.syncVersion = syncVersion;
	}

	/**
	 * Catalog title.
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Catalog title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Updated is the last modification date and time of the catalog.
	 */
	public Date getUpdated() {
		return this.updated;
	}

	/**
	 * Updated is the last modification date and time of the catalog.
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	/**
	 * Date when the catalog will become effective.
	 */
	public String getValidFrom() {
		return this.validFrom;
	}

	/**
	 * Date when the catalog will become effective.
	 */
	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}

	/**
	 * Date when the catalog will expire.
	 */
	public String getValidUntil() {
		return this.validUntil;
	}

	/**
	 * Date when the catalog will expire.
	 */
	public void setValidUntil(String validUntil) {
		this.validUntil = validUntil;
	}

	/**
	 * Vendor that offers this catalog.
	 */
	public Vendor getVendor() {
		return this.vendor;
	}

	/**
	 * Vendor that offers this catalog.
	 */
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
}

