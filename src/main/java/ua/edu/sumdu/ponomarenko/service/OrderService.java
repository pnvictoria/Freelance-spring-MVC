package ua.edu.sumdu.ponomarenko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.edu.sumdu.ponomarenko.dao.DAOMain;
import ua.edu.sumdu.ponomarenko.models.Orders;

import java.util.List;

@Service
public class OrderService implements MainService<Orders> {

    @Qualifier("DAOOrdersImpl")
    @Autowired
    private DAOMain<Orders> daoOrder;

    @Override
    public boolean addObject(Orders obj) {
        List<Orders> byItem = daoOrder.getByItem(obj);
        if(byItem.isEmpty()) {
            daoOrder.addObject(obj);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void removeObject(int id) {
        daoOrder.removeObject(id);
    }

    @Override
    public void updateObject(Orders obj) {
        daoOrder.updateObject(obj);
    }

    @Override
    public Orders getObjectById(int id) {
        return daoOrder.getObjectById(id);
    }

    @Override
    public List<Orders> getObjects() {
        return daoOrder.getObjects();
    }

    @Override
    public List<Orders> getByItem(Orders obj) {
        return daoOrder.getByItem(obj);
    }
}
