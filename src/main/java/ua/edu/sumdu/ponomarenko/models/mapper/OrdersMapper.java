package ua.edu.sumdu.ponomarenko.models.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ua.edu.sumdu.ponomarenko.models.Orders;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrdersMapper implements RowMapper<Orders> {

    @Override
    public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
        Orders orders = new Orders();
        orders.setOrderId(rs.getInt("order_id"));
        orders.setTitleOrder(rs.getString("title_order"));
        orders.setDescriptionOrder(rs.getString("description_order"));
        orders.setPrice(rs.getInt("price"));
        orders.setAccount(rs.getInt("account_fk"));
        return orders;
    }
}
