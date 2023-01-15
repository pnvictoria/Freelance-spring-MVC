package ua.edu.sumdu.ponomarenko.models.mapper;

import org.springframework.jdbc.core.RowMapper;
import ua.edu.sumdu.ponomarenko.models.Skills;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SkillsMapper implements RowMapper<Skills> {

    @Override
    public Skills mapRow(ResultSet rs, int rowNum) throws SQLException {
        Skills skills = new Skills();
        skills.setSkillsId(rs.getInt("skills_id"));
        skills.setSkillsTitle(rs.getString("skills_title"));

//        skills.setSpecialization();
        return skills;
    }
}
