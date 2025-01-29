package com.example.springjdbc.Repositly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.springjdbc.domain.PracEmployee;

@Repository
public class PracEmployeeRepository {
  @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void save(PracEmployee pracEmployee) {
        String sql = "INSERT INTO employees (name, age, gender, department_id) VALUES (:name, :age, :gender, :departmentId)";
        BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(pracEmployee);
        jdbcTemplate.update(sql, paramSource);
    }
}
