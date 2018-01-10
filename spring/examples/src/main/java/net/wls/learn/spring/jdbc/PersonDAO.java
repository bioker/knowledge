package net.wls.learn.spring.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

public class PersonDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int savePerson(Person person) {
        String query = "insert into Person values (" +
                person.getId() + ",'" + person.getName() + "')";
        return jdbcTemplate.update(query);
    }

    public int updatePerson(Person person) {
        String query = "update person set name='" +
                person.getName() + "' where id='" + person.getId() + "'";
        return jdbcTemplate.update(query);
    }

    public int deletePerson(Person person) {
        String query = "delete from person where id='" + person.getId() + "'";
        return jdbcTemplate.update(query);
    }
}
