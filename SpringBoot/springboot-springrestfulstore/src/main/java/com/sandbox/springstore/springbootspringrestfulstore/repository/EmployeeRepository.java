package com.sandbox.springstore.springbootspringrestfulstore.repository;

import com.sandbox.springstore.springbootspringrestfulstore.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Employee employee = new Employee();
        employee.setEmployeeId(rs.getLong("EmployeeID"));
        employee.setName(rs.getString("Name"));
        //employee.setSalary(rs.getString("Salary"));

        return employee;
    }
}

/**
 *
 */
@Repository
public class EmployeeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly=true)
    public List<Employee> findAll() {
        List <Employee> employeeList = jdbcTemplate.query("SELECT * FROM Production.Employee",
                new EmployeeRowMapper());

        System.out.println("Found: " + employeeList.size());
        return employeeList;
    }

    @Transactional(readOnly=true)
    public Employee findOne(long id) {
        Object [] parameters = new Object [] { id };
        System.out.println("Calling findOne  " + id);
        Employee employee =
                jdbcTemplate.queryForObject("SELECT * FROM Production.Employee where employeeId = ?",
                        parameters, new EmployeeRowMapper());

        System.out.println("Found: " + employee.getEmployeeId());
        return employee;
    }
}
