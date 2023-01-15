package ua.edu.sumdu.ponomarenko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.edu.sumdu.ponomarenko.models.Country;
import ua.edu.sumdu.ponomarenko.models.mapper.CountryMapper;

import java.util.List;

@Component
public class DAOCountryImpl implements DAOMain<Country> {

    private final JdbcTemplate jdbcTemplate;
    private final CountryMapper mapper;

    @Autowired
    public DAOCountryImpl(JdbcTemplate jdbcTemplate, CountryMapper mapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    @Override
    public void addObject(Country obj) {
        String sql = "INSERT INTO country(\n" +
                "\tcountry_id, country_name)\n" +
                "\tVALUES (?, ?);";
        jdbcTemplate.update(sql,
                (ps -> {
                    ps.setInt(1, obj.getCountryId());
                    ps.setString(2, obj.getCountryName());
                }));
    }

    @Override
    public void removeObject(int id) {
        String sql = "DELETE FROM country\n" +
                "\tWHERE country_id =" + id;
        jdbcTemplate.update(sql);
    }

    @Override
    public void updateObject(Country obj) {
        String sql = "UPDATE country\n" +
                "\tSET country_id=?, country_name=?\n" +
                "\tWHERE country_id =" + obj.getCountryId();
        jdbcTemplate.update(sql,
                (ps -> {
                    ps.setInt(1, obj.getCountryId());
                    ps.setString(2, obj.getCountryName());
                }));
    }

    @Override
    public Country getObjectById(int id) {
        String sql = "SELECT * FROM country " +
                "WHERE country_id = " + id;
        return jdbcTemplate.queryForObject(sql,mapper);
    }

    @Override
    public List<Country> getObjects() {
        String sql = "SELECT * FROM country";
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<Country> getByItem(Country obj) {
        return null;
    }
}
