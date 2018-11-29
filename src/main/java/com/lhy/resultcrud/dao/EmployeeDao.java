package com.lhy.resultcrud.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.lhy.resultcrud.entities.Department;
import com.lhy.resultcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

    private static Map<Long, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Long, Employee>();

        employees.put(1001L, new Employee(1001L, "E-AA", "aa@163.com", 1, new Department(101, "D-AA")));
        employees.put(1002L, new Employee(1002L, "E-BB", "bb@163.com", 1, new Department(102, "D-BB")));
        employees.put(1003L, new Employee(1003L, "E-CC", "cc@163.com", 0, new Department(103, "D-CC")));
        employees.put(1004L, new Employee(1004L, "E-DD", "dd@163.com", 0, new Department(104, "D-DD")));
        employees.put(1005L, new Employee(1005L, "E-EE", "ee@163.com", 1, new Department(105, "D-EE")));
    }

    private static Integer initId = 1006;

    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(Long.valueOf(initId++));
        }

        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll() {
        return employees.values();
    }

    public Employee get(Integer id) {
        return employees.get(id);
    }

    public void delete(Integer id) {
        employees.remove(id);
    }
}
