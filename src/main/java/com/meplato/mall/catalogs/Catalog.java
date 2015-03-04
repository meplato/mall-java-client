package com.meplato.mall.catalogs;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Catalog data.
 */
public class Catalog {
    @SerializedName("catalogManaged")
    private boolean catalogManaged;
    @SerializedName("currency")
    private String currency;
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
    @SerializedName("selfLink")
    private String selfLink;
    @SerializedName("syncVersion")
    private long syncVersion;
    @SerializedName("title")
    private String title;
    @SerializedName("validFrom")
    private String validFrom;
    @SerializedName("validUntil")
    private String validUntil;

    /**
     * Create new instance of Catalog.
     */
    public Catalog() {
    }

    /**
     * Indicates whether the catalog is 'catalog managed' according to SAP OCI 5.
     */
    public boolean isCatalogManaged() {
        return this.catalogManaged;
    }

    /**
     * Indicates whether the catalog is 'catalog managed' according to SAP OCI 5.
     */
    public void setCatalogManaged(boolean catalogManaged) {
        this.catalogManaged = catalogManaged;
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
     * Kind is store#catalog for a catalog entity.
     */
    public String getKind() {
        return this.kind;
    }

    /**
     * Kind is store#catalog for a catalog entity.
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
}

