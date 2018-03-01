package org.aming.tss.base.ds.mysql;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author daming
 * @version 2018/2/26.
 */
public class Column implements Serializable {

	private static final long serialVersionUID = 2737564783266069290L;
	private String field;
	private String type;
	private String nullFlag;
	private String key;
	private String defaultValue;
	private String extra;

	public String getField() {
		return field;
	}

	public Column setField(String field) {
		this.field = field;
		return this;
	}

	public String getType() {
		return type;
	}

	public Column setType(String type) {
		this.type = type;
		return this;
	}

	public String getNullFlag() {
		return nullFlag;
	}

	public Column setNullFlag(String nullFlag) {
		this.nullFlag = nullFlag;
		return this;
	}

	public String getKey() {
		return key;
	}

	public Column setKey(String key) {
		this.key = key;
		return this;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public Column setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
		return this;
	}

	public String getExtra() {
		return extra;
	}

	public Column setExtra(String extra) {
		this.extra = extra;
		return this;
	}

	public Column() {
		super();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
