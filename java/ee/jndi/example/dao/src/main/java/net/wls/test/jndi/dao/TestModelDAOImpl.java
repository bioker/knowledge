package net.wls.test.jndi.dao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TestModelDAOImpl implements TestModelDAO {

    @Getter
    @Setter
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TestModel> findAll() {
        return jdbcTemplate.query("select * from test", new RowMapper<TestModel>() {
            @Override
            public TestModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                TestModel testModel = new TestModel();
                testModel.setId(rs.getInt(1));
                testModel.setName(rs.getString(2));
                return testModel;
            }
        });
    }
}
