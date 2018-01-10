package net.wls.learn.spring.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RowPersonDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> getAllPersons() {
        String query = "select * from person";
        return jdbcTemplate.query(query, new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Person(
                        resultSet.getInt(1),
                        resultSet.getString(2)
                );
            }
        });
    }
}
