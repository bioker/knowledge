package net.wls.learn.spring.jdbc;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParametrizedPersonDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Boolean savePerson(final Person person) {
        String query = "insert into person values(?,?)";
        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement)
                    throws SQLException, DataAccessException {
                preparedStatement.setInt(1, person.getId());
                preparedStatement.setString(2, person.getName());
                return preparedStatement.execute();
            }
        });
    }
}
