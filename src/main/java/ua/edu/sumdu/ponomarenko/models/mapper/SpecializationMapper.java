package ua.edu.sumdu.ponomarenko.models.mapper;

import org.springframework.jdbc.core.RowMapper;
import ua.edu.sumdu.ponomarenko.models.Specialization;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecializationMapper implements RowMapper<Specialization> {

    @Override
    public Specialization mapRow(ResultSet rs, int rowNum) throws SQLException {
        Specialization specialization = new Specialization();
        specialization.setSpecializationId(rs.getInt("specialization_id"));
        specialization.setSpecializationTitle(rs.getString("specialization_title"));
        return specialization;
    }
}
