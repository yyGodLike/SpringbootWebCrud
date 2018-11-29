package com.lhy.resultcrud.dao;

import com.lhy.resultcrud.entities.Employee;

import java.util.Collection;


public interface EmployeeMapper {

    public void save(Employee employee);

    public Collection<Employee> getAll();

    public Employee get(Integer id);

    public void delete(Integer id);

}
