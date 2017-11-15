package net.wls.learn.spring.jdbc;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class NamedPersonDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void savePerson(Person person) {
        String query = "insert into person values(:id,:name)";
        Map<String, Object> map = new HashMap<>();
        map.put("id", person.getId());
        map.put("name", person.getName());
        jdbcTemplate.execute(query, map, new PreparedStatementCallback<Integer>() {
            @Override
            public Integer doInPreparedStatement(PreparedStatement preparedStatement)
                    throws SQLException, DataAccessException {
                return preparedStatement.executeUpdate();
            }
        });
    }

}
