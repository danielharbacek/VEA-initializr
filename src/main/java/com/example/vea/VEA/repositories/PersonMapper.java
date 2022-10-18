package com.example.vea.VEA.repositories;

import com.example.vea.VEA.models.Address;
import com.example.vea.VEA.models.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();
        person.setId(rs.getLong("id"));
        person.setFirstName(rs.getString("first_name"));
        person.setLastName(rs.getString("last_name"));
        Address address = new Address();
        address.setStreet(rs.getString("street"));
        address.setCity(rs.getString("city"));
        person.setAddress(address);
        return person;
    }
}
