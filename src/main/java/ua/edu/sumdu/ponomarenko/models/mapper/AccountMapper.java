package ua.edu.sumdu.ponomarenko.models.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ua.edu.sumdu.ponomarenko.models.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AccountMapper implements RowMapper<Account> {

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("account_id"));
        account.setEmail(rs.getString("email"));
        account.setPassword(rs.getString("password"));
        account.setPhone(rs.getString("phone"));
        account.setDescription(rs.getString("description"));
        account.setName(rs.getString("name"));
        account.setSurname(rs.getString("surname"));
        account.setSex(rs.getBoolean("sex"));
        account.setRole(roleMapper.mapRow(rs,rowNum));
        account.setCountry(countryMapper.mapRow(rs, rowNum));
        return account;
    }
}
