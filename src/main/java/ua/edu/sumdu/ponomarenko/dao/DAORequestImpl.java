package ua.edu.sumdu.ponomarenko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.edu.sumdu.ponomarenko.models.Request;
import ua.edu.sumdu.ponomarenko.models.mapper.RequestMapper;

import java.util.List;

@Component
public class DAORequestImpl implements DAOMain<Request> {

    private final JdbcTemplate jdbcTemplate;
    private final RequestMapper mapper;

    @Autowired
    public DAORequestImpl(JdbcTemplate jdbcTemplate, RequestMapper mapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    @Override
    public void addObject(Request obj) {
        String sql = "INSERT INTO request(\n" +
                "\t account_fk, order_fk, request_description)\n" +
                "\tVALUES (?, ?, ?);";

        jdbcTemplate.update(sql,
                (ps -> {
                    ps.setInt(1, obj.getAccount());
                    ps.setInt(2, obj.getOrder().getOrderId());
                    ps.setString(3, obj.getRequestDescription());
                }));
    }

    @Override
    public void removeObject(int id) {

    }

    @Override
    public void updateObject(Request obj) {

    }

    @Override
    public Request getObjectById(int id) {
        String sql = "SELECT *\n" +
                "FROM request rq\n" +
                "FULL JOIN account ac ON ac.account_id = rq.account_fk\n" +
                "FULL JOIN orders od ON od.order_id = rq.order_fk\n" +
                "WHERE rq.request_id = " + id;
        return jdbcTemplate.queryForObject(sql, mapper);
    }

    @Override
    public List<Request> getObjects() {
        String sql = "SELECT *\n" +
                "FROM request rq\n" +
                "FULL JOIN account ac ON ac.account_id = rq.account_fk\n" +
                "FULL JOIN orders od ON od.order_id = rq.order_fk\n" +
                "WHERE rq.request_id IS NOT NULL\n";
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<Request> getByItem(Request obj) {
        String sql = "SELECT *\n" +
                "FROM request rq\n" +
                "FULL JOIN account ac ON ac.account_id = rq.account_fk\n" +
                "FULL JOIN orders od ON od.order_id = rq.order_fk\n" +
                "WHERE rq.account_fk = ?";
        return jdbcTemplate.query(sql, new Object[]{
                obj.getAccount()
        }, mapper);
    }
}
