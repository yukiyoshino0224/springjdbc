package com.example.springjdbc.Repositly;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.springjdbc.domain.Employee;

@Repository
public class EmployeeRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    public Employee load(Integer id){
        System.out.println("Repositoryのload()が呼ばれました");
        return null;
    }

    public List<Employee> findAll(){
        System.out.println("RepositoryのfindAll()が呼ばれました");
        return new ArrayList<Employee>();
    }

    public Employee save(Employee employee){
        System.out.println("Repositoryのsave()が呼ばれました　employee = " + employee);
        return null;
    }

    public void deleteById(Integer id){
        System.out.println("RepositoryのdeleteById()が呼ばれました　id = " + id);
    }
}