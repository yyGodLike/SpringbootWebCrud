package com.lhy.resultcrud.dao;

import com.lhy.resultcrud.entities.Department;

import java.util.Collection;

public interface DepartmentMapper {

    public Collection<Department> getDepartments();

    public Department getDepartment(Integer id);

}
