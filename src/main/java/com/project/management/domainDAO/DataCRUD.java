package com.project.management.domainDAO;


import java.sql.SQLException;

public abstract class DataCRUD<T> {
    public abstract void create(T t) throws SQLException;

    public abstract void read() throws SQLException;

    public abstract void update(T t) throws SQLException;

    public abstract void delete(String name) throws SQLException;

}

