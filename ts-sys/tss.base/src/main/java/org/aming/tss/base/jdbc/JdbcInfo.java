package org.aming.tss.base.jdbc;

import org.aming.tss.base.enums.DataBaseType;

import java.io.Serializable;

/**
 * @author daming
 * @version 2018/1/30.
 */
public class JdbcInfo implements Serializable {

    private static final long serialVersionUID = 2999656653712335629L;

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public JdbcInfo setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public JdbcInfo setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public JdbcInfo setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public JdbcInfo setPassword(String password) {
        this.password = password;
        return this;
    }

    public JdbcInfo() {
        super();
    }

    public static JdbcInfo getJdbcInfo(DataBase dataBase) {
        DataBaseType dataBaseType = DataBaseType.getDataBaseType(dataBase.getType());
        if (dataBaseType == DataBaseType.MYSQL) {

        } else {

        }

        return new JdbcInfo();
    }
}
