package ua.edu.sumdu.ponomarenko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.edu.sumdu.ponomarenko.models.Account;
import ua.edu.sumdu.ponomarenko.models.Orders;
import ua.edu.sumdu.ponomarenko.models.mapper.OrdersMapper;

import java.util.List;

@Component
public class DAOOrdersImpl implements DAOMain<Orders> {

    private final JdbcTemplate jdbcTemplate;
    private final OrdersMapper mapper;

    @Autowired
    public DAOOrdersImpl(JdbcTemplate jdbcTemplate, OrdersMapper mapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    @Override
    public void addObject(Orders obj) {
        String sql = "INSERT INTO orders (\n" +
                "\t title_order, description_order, price, account_fk)\n" +
                "\tVALUES (?, ?, ?, ?);";

        jdbcTemplate.update(sql,
                (ps -> {
                    ps.setString(1, obj.getTitleOrder());
                    ps.setString(2, obj.getDescriptionOrder());
                    ps.setInt(3, obj.getPrice());
                    ps.setInt(4,obj.getAccount());
                }));
    }

    @Override
    public void removeObject(int id) {

    }

    @Override
    public void updateObject(Orders obj) {

    }

    @Override
    public Orders getObjectById(int id) {
        String sql = "SELECT * FROM orders " +
                "WHERE order_id = " + id;
        return jdbcTemplate.queryForObject(sql,mapper);
    }

    @Override
    public List getObjects() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<Orders> getByItem(Orders obj) {
        String sql = "SELECT * FROM orders " +
                "WHERE account_fk = ? ";
        return jdbcTemplate.query(sql, new Object[]{
                obj.getOrderId()
        }, mapper);
    }
}
