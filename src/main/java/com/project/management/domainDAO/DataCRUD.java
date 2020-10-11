package com.project.management.domainDAO;

public abstract class DataCRUD<T>{
    public abstract void create(T t);
    public abstract void read(T t);
    public abstract void update(T t);
    public abstract void delete(T t);

}
