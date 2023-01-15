package ua.edu.sumdu.ponomarenko.dao;


public interface DAOConnection<T> {
    /**
     * the method for connection to Data Base
     */
    void connect();

    /**
     * the method for disconnection from Data base
     */
    void disconnect();
}
