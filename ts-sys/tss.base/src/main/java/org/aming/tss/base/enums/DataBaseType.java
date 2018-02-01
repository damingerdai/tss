package org.aming.tss.base.enums;

/**
 * @author daming
 * @version 2018/1/30.
 */
public enum DataBaseType {

    MYSQL(1,"MySql"), MSSQL(2, "Sql Server");

    private int type;
    private String name;

    DataBaseType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public static DataBaseType getDataBaseType(int type) {
        for (DataBaseType db: values()) {
            if (db.type == type) {
                return db;
            }
        }
        throw new IllegalArgumentException("type '" + type + "' is illegal");
    }

    public static boolean isDataBaseType(int type) {
        for (DataBaseType db: values()) {
            if (db.type == type) {
                return true;
            }
        }
        return false;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
