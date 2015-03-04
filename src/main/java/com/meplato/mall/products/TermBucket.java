package com.meplato.mall.products;

import com.google.gson.annotations.SerializedName;

/**
 * TermBucket is a single bucket of a term facet.
 */
public class TermBucket {
    @SerializedName("count")
    private long count;
    @SerializedName("value")
    private String value;

    /**
     * Create new instance of TermBucket.
     */
    public TermBucket() {
    }

    /**
     * Count is the number of items found for this bucket.
     */
    public long getCount() {
        return this.count;
    }

    /**
     * Count is the number of items found for this bucket.
     */
    public void setCount(long count) {
        this.count = count;
    }

    /**
     * Value is the value of the bucket.
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Value is the value of the bucket.
     */
    public void setValue(String value) {
        this.value = value;
    }
}

