package ua.edu.sumdu.ponomarenko.models.mapper;

import org.springframework.jdbc.core.RowMapper;
import ua.edu.sumdu.ponomarenko.models.Account;
import ua.edu.sumdu.ponomarenko.models.OrderAccount;
import ua.edu.sumdu.ponomarenko.models.Orders;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderAccountMapper implements RowMapper<OrderAccount> {
    @Override
    public OrderAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderAccount orderAccount = new OrderAccount();
        Orders orders = new Orders();
        Account account = new Account();

//        orderAccount.setOrderCustomerFK();
//        orderAccount.setAccountExecutorFK();
        return orderAccount;
    }
}
