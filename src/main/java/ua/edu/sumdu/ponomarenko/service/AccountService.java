package ua.edu.sumdu.ponomarenko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.edu.sumdu.ponomarenko.dao.DAOMain;
import ua.edu.sumdu.ponomarenko.models.Account;

import java.util.List;

@Service
public class AccountService implements MainService<Account> {

    @Qualifier("DAOAccountImpl")
    @Autowired
    private DAOMain<Account> daoAccount;

    @Override
    public boolean addObject(Account obj) {
        List<Account> byItem = daoAccount.getByItem(obj);
        if(byItem.isEmpty()) {
            daoAccount.addObject(obj);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void removeObject(int id) {
        daoAccount.removeObject(id);
    }

    @Override
    public void updateObject(Account obj) {
        daoAccount.updateObject(obj);
    }

    @Override
    public Account getObjectById(int id) {
        return daoAccount.getObjectById(id);
    }

    @Override
    public List<Account> getObjects() {
        return daoAccount.getObjects();
    }

    @Override
    public List<Account> getByItem(Account obj) {
        return daoAccount.getByItem(obj);
    }

}
