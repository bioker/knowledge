package net.wls.learn.spring.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO {

    private JdbcTemplate jdbcTemplate;

    public User findByName(String name) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE name='" + name + "'",
                new UserMapper());
    }

    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users", new UserMapper());
    }

    private static final class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt(rs.findColumn("id")));
            user.setName(rs.getString(rs.findColumn("name")));
            user.setEmail(rs.getString(rs.findColumn("email")));
            return user;
        }
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
