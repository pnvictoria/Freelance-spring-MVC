package ua.edu.sumdu.ponomarenko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.edu.sumdu.ponomarenko.dao.DAOMain;
import ua.edu.sumdu.ponomarenko.models.Country;

import java.util.List;

@Service
public class CountryService implements MainService<Country> {

    @Qualifier("DAOCountryImpl")
    @Autowired
    private DAOMain<Country> daoCountry;

    @Override
    public boolean addObject(Country obj) {
        daoCountry.addObject(obj);
        return true;
    }

    @Override
    public void removeObject(int id) {
        daoCountry.removeObject(id);
    }

    @Override
    public void updateObject(Country obj) {
        daoCountry.updateObject(obj);
    }

    @Override
    public Country getObjectById(int id) {
        return (Country) daoCountry.getObjectById(id);
    }

    @Override
    public List<Country> getObjects() {
        return daoCountry.getObjects();
    }

    @Override
    public List<Country> getByItem(Country obj) {
        return null;
    }
}
