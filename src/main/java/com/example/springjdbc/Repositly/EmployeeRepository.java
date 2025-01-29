package com.example.springjdbc.Repositly;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.springjdbc.domain.Employee;

@Repository
public class EmployeeRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = (rs, i) -> {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setAge(rs.getInt("age"));
        employee.setGender(rs.getString("gender"));
        return employee;        
    };;

    public Employee load(Integer id){
        String sql =
        "SELECT id,name,age,gender,department_id FROM employees WHERE id =:id";
        
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

        Employee emplyee = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);

        return emplyee;
    }

    public List<Employee> findAll(){

        String sql = "SELECT id,name,age,gender,department_id FROM employees ORDER BY age";

        List<Employee> employeeList = template.query(sql, EMPLOYEE_ROW_MAPPER);

        return employeeList;
    }

    public void deleteById(Integer id){
        System.out.println("RepositoryのdeleteById()が呼ばれました　id = " + id);
    }

    public Employee save(Employee employee){
        SqlParameterSource param = new BeanPropertySqlParameterSource(employee);

        if(employee.getId() == null){
            String insertSql = "INSERT INTO employees(name,gender,department_id)" + "VALUES(:name,:age,:gender,:departmentId)";
            template.update(insertSql, param);
        }else{
            String updateSql = "UPDATE employees SET name=:name, age=:age, " + "gender=:gender,department_id=:departmentId " + " WHERE id=:id";
            template.update(updateSql, param);
        }
        return employee;
    }
}
