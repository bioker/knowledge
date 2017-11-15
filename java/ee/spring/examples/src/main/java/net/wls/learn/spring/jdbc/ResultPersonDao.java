package net.wls.learn.spring.jdbc;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultPersonDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> getAllPersons() {
        String query = "select * from person";
        return jdbcTemplate.query(query, new ResultSetExtractor<List<Person>>() {
            @Override
            public List<Person> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Person> personList = new ArrayList<>();
                while (resultSet.next()) {
                    personList.add(
                            new Person(
                                    resultSet.getInt(1),
                                    resultSet.getString(2)
                            )
                    );
                }
                return personList;
            }
        });
    }
}
