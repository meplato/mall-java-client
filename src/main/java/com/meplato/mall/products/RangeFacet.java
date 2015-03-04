package com.meplato.mall.products;

import com.google.gson.annotations.SerializedName;

/**
 * RangeFacet returns range-based facet.
 */
public class RangeFacet {
    @SerializedName("buckets")
    private RangeBucket[] buckets;

    /**
     * Create new instance of RangeFacet.
     */
    public RangeFacet() {
    }

    /**
     * Buckets stores the actual results.
     */
    public RangeBucket[] getBuckets() {
        return this.buckets;
    }

    /**
     * Buckets stores the actual results.
     */
    public void setBuckets(RangeBucket[] buckets) {
        this.buckets = buckets;
    }
}

