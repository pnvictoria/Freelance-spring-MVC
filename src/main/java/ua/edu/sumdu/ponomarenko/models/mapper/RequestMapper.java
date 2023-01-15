package ua.edu.sumdu.ponomarenko.models.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ua.edu.sumdu.ponomarenko.models.Request;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RequestMapper implements RowMapper<Request> {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public Request mapRow(ResultSet rs, int rowNum) throws SQLException {
        Request request = new Request();
        request.setRequestId(rs.getInt("request_id"));
        request.setRequestDescription(rs.getString("request_description"));
        request.setAccount(rs.getInt("account_fk"));
        request.setOrder(ordersMapper.mapRow(rs,rowNum));
        return request;
    }
}
