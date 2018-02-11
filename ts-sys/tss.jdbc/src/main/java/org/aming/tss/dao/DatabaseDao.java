package org.aming.tss.dao;

import org.aming.tss.base.jdbc.DataBase;

import java.util.List;

/**
 * @author daming
 * @version 2018/2/4.
 */
public interface DatabaseDao {

    List<DataBase> getAllDataBase();
}
