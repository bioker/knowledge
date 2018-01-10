package net.wls.test.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ConfRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void test() throws SQLException {
        jdbcTemplate.query("SELECT * FROM test", new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                System.out.println(rs.getInt(1));
                return rs.getInt(1);
            }
        });
    }

}
