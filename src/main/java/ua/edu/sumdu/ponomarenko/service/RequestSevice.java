package ua.edu.sumdu.ponomarenko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.edu.sumdu.ponomarenko.dao.DAOMain;
import ua.edu.sumdu.ponomarenko.models.Request;

import java.util.List;

@Service
public class RequestSevice implements MainService<Request> {

    @Qualifier("DAORequestImpl")
    @Autowired
    private DAOMain<Request> daoRequest;

    @Override
    public boolean addObject(Request obj) {
        daoRequest.addObject(obj);
        return true;
    }

    @Override
    public void removeObject(int id) {

    }

    @Override
    public void updateObject(Request obj) {

    }

    @Override
    public Request getObjectById(int id) {
        return daoRequest.getObjectById(id);
    }

    @Override
    public List<Request> getObjects() {
        return daoRequest.getObjects();
    }

    @Override
    public List<Request> getByItem(Request obj) {
        return daoRequest.getByItem(obj);
    }
}
