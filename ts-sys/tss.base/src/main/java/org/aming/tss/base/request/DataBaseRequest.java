package org.aming.tss.base.request;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author daming
 * @version 2018/2/1.
 */
public class DataBaseRequest implements Serializable{

    private static final long serialVersionUID = 3778452930982734105L;

    private String host;
    private int port;
    private String username;
    private String password;

    public String getHost() {
        return host;
    }

    public DataBaseRequest setHost(String host) {
        this.host = host;
        return this;
    }

    public int getPort() {
        return port;
    }

    public DataBaseRequest setPort(int port) {
        this.port = port;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public DataBaseRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public DataBaseRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    public DataBaseRequest() {
        super();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
