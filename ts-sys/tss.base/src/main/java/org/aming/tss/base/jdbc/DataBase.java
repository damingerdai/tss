package org.aming.tss.base.jdbc;

import java.io.Serializable;

/**
 * @author daming
 * @version 2018/1/30.
 */
public class DataBase implements Serializable {

    private static final long serialVersionUID = -3693892426926277731L;

    private int type;

    private String host;

    private int port;

    private String username;

    private String password;

    private String databaseName;

    public int getType() {
        return type;
    }

    public DataBase setType(int type) {
        this.type = type;
        return this;
    }

    public String getHost() {
        return host;
    }

    public DataBase setHost(String host) {
        this.host = host;
        return this;
    }

    public int getPort() {
        return port;
    }

    public DataBase setPort(int port) {
        this.port = port;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public DataBase setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public DataBase setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public DataBase setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
        return this;
    }
}
