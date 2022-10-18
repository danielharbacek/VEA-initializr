package com.example.vea.VEA.repositories;

import com.example.vea.VEA.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class PersonRepository {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;

    @PostConstruct
    public void init(){
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("persons")
                .usingGeneratedKeyColumns("id")
                .usingColumns("first_name", "last_name", "city", "street");

        try{
            Connection connection = dataSource.getConnection();
            Statement stmt = connection.createStatement();
            String sql = "create table persons (id integer not null auto_increment, first_name varchar(255), last_name varchar(255), street varchar(255), city varchar(255), primary key (id));";
            stmt.execute(sql);
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    public List<Person> getAll(){
        return jdbcTemplate.query("select * from persons", new PersonMapper());
    }

    public void insertPerson(Person person){
        BeanPropertySqlParameterSource bean = new BeanPropertySqlParameterSource(person);
        jdbcInsert.execute(bean);
    }

    public void updatePerson(Person person){
        jdbcTemplate.update("update persons set first_name = ?, last_name = ?, street = ?, city = ? where id = ?",
                person.getFirstName(), person.getLastName(), person.getStreet(), person.getCity(), person.getId());
    }

    public Person findById(long id){
        return jdbcTemplate.queryForObject("select * from persons where id = ?", new PersonMapper(), id);
    }
}
