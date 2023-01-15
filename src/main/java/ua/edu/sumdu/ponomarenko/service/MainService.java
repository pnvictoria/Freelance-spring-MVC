package ua.edu.sumdu.ponomarenko.service;

import java.util.List;

public interface MainService<T> {

    boolean addObject(T obj);

    void removeObject(int id);

    void updateObject(T obj);

    T getObjectById(int id);

    List<T> getObjects();

    List<T> getByItem(T obj);

}

