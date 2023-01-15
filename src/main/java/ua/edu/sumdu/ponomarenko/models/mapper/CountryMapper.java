package ua.edu.sumdu.ponomarenko.models.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ua.edu.sumdu.ponomarenko.models.Country;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CountryMapper implements RowMapper<Country> {
    @Override
    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
        Country country = new Country();
        country.setCountryId(rs.getInt("country_id"));
        country.setCountryName(rs.getString("country_name"));
        return country;
    }
}
