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
package com.meplato.mall.products;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

