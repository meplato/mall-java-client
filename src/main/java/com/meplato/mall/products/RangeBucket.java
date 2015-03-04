package com.meplato.mall.products;

import com.google.gson.annotations.SerializedName;

/**
 * RangeBucket is a single range-based bucket.
 */
public class RangeBucket {
    @SerializedName("count")
    private long count;
    @SerializedName("from")
    private double from;
    @SerializedName("to")
    private double to;

    /**
     * Create new instance of RangeBucket.
     */
    public RangeBucket() {
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
     * From is the starting point of the range (if any).
     */
    public double getFrom() {
        return this.from;
    }

    /**
     * From is the starting point of the range (if any).
     */
    public void setFrom(double from) {
        this.from = from;
    }

    /**
     * To is the end point of the range (if any).
     */
    public double getTo() {
        return this.to;
    }

    /**
     * To is the end point of the range (if any).
     */
    public void setTo(double to) {
        this.to = to;
    }
}

