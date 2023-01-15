package ua.edu.sumdu.ponomarenko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.edu.sumdu.ponomarenko.models.Account;
import ua.edu.sumdu.ponomarenko.models.mapper.AccountMapper;

import java.util.List;

@Component
public class DAOAccountImpl implements DAOMain<Account> {

    private final JdbcTemplate jdbcTemplate;
    private final AccountMapper mapper;

    @Autowired
    public DAOAccountImpl(JdbcTemplate jdbcTemplate, AccountMapper mapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    @Override
    public void addObject(Account obj) {
        String sql = "INSERT INTO public.account(\n" +
                "\t email, password, phone, description," +
                " country_fk, role_fk, name, surname, sex)\n" +
                "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

        jdbcTemplate.update(sql,
                (ps -> {
                    ps.setString(1, obj.getEmail());
                    ps.setString(2, obj.getPassword());
                    ps.setString(3, obj.getPhone());
                    ps.setString(4, obj.getDescription());
                    ps.setInt(5, obj.getCountry().getCountryId());
                    ps.setInt(6, obj.getRole().getId());
                    ps.setString(7, obj.getName());
                    ps.setString(8, obj.getSurname());
                    ps.setBoolean(9, obj.getSex());
                }));
    }

    @Override
    public void removeObject(int id) {
        String sql = "DELETE FROM account\n" +
                "\tWHERE account_id = ?; " +
                "DELETE FROM orders\n" +
                "\tWHERE account_fk = ?; " +
                "DELETE FROM request\n" +
                "\tWHERE account_fk = ?; ";
        jdbcTemplate.update(sql,
                (ps -> {
                    ps.setInt(1, id);
                    ps.setInt(2, id);
                    ps.setInt(3, id);
                }));
    }

    @Override
    public void updateObject(Account obj) {
        String sql = "UPDATE account\n" +
                "\tSET email = ?, password = ?, phone = ?, description = ?," +
                " country_fk = ?, role_fk = ?, name = ?, surname = ?, sex = ? " +
                "WHERE account_id = ?";
        jdbcTemplate.update(sql,
                (ps -> {
                    ps.setString(1, obj.getEmail());
                    ps.setString(2, obj.getPassword());
                    ps.setString(3, obj.getPhone());
                    ps.setString(4, obj.getDescription());
                    ps.setInt(5, obj.getCountry().getCountryId());
                    ps.setInt(6, obj.getRole().getId());
                    ps.setString(7, obj.getName());
                    ps.setString(8, obj.getSurname());
                    ps.setBoolean(9, obj.getSex());
                    ps.setInt(10, obj.getId());
                }));
    }

    @Override
    public Account getObjectById(int id) {
        String sql = "SELECT *\n" +
                "FROM account a\n" +
                "FULL JOIN role r ON a.role_fk = r.role_id\n" +
                "FULL JOIN country c ON a.country_fk = c.country_id\n" +
                "WHERE account_id = " + id;
        return jdbcTemplate.queryForObject(sql, mapper);
    }

    @Override
    public List getObjects() {
        String sql = "SELECT *\n" +
                "FROM account a\n" +
                "FULL JOIN role r ON a.role_fk = r.role_id\n" +
                "FULL JOIN country c ON a.country_fk = c.country_id";
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<Account> getByItem(Account obj) {
        String sql = "SELECT *\n" +
                "FROM account a\n" +
                "FULL JOIN role r ON (a.role_fk = r.role_id)\n" +
                "FULL JOIN country c ON a.country_fk = c.country_id\n" +
                "WHERE a.email = ?";
        return jdbcTemplate.query(sql, new Object[]{
                obj.getEmail()
        }, mapper);
    }
}