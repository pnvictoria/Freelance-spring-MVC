package ua.edu.sumdu.ponomarenko.dao;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DAOMain<T> {

    /**
     * the method for inserting Object to Data Base
     * @param obj
     */
    void addObject(T obj);

    /**
     * the method for deleting Object from Data Base
     * @param id
     */
    void removeObject(int id);

    /**
     * the method for update Object in Data Base
     * @param obj
     */
    void updateObject(T obj);

    /**
     * the method for getting objects from Data Base
     * @return
     */

    T getObjectById(int id);

    List<T> getObjects();

    List<T> getByItem(T obj);
}
