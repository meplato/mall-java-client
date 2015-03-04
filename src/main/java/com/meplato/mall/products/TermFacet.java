package com.meplato.mall.products;

import com.google.gson.annotations.SerializedName;

/**
 * TermFacet returns a term-based facet.
 */
public class TermFacet {
    @SerializedName("buckets")
    private TermBucket[] buckets;
    @SerializedName("count")
    private long count;

    /**
     * Create new instance of TermFacet.
     */
    public TermFacet() {
    }

    /**
     * Buckets stores the actual results.
     */
    public TermBucket[] getBuckets() {
        return this.buckets;
    }

    /**
     * Buckets stores the actual results.
     */
    public void setBuckets(TermBucket[] buckets) {
        this.buckets = buckets;
    }

    /**
     * Count is the total number of buckets.
     */
    public long getCount() {
        return this.count;
    }

    /**
     * Count is the total number of buckets.
     */
    public void setCount(long count) {
        this.count = count;
    }
}

