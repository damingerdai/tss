package org.aming.tss.base.jdbc;

import org.aming.tss.base.enums.DataBaseType;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author daming
 * @version 2018/1/30.
 */
public class Database implements Serializable {

	private static final long serialVersionUID = 8968823470833943722L;

	private int id;
	private String name;
	private String url;
	private String driver;
	private String username;
	private String password;
	private DataBaseType type;

	public int getId() {
		return id;
	}

	public Database setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Database setName(String name) {
		this.name = name;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public Database setUrl(String url) {
		this.url = url;
		return this;
	}

	public String getDriver() {
		return driver;
	}

	public Database setDriver(String driver) {
		this.driver = driver;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public Database setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Database setPassword(String password) {
		this.password = password;
		return this;
	}

	public DataBaseType getType() {
		return type;
	}

	public Database setType(DataBaseType type) {
		this.type = type;
		return this;
	}

	public Database() {
		super();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
