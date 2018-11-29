package com.lhy.resultcrud.controller;

import com.lhy.resultcrud.dao.DepartmentDao;
import com.lhy.resultcrud.dao.DepartmentMapper;
import com.lhy.resultcrud.dao.EmployeeDao;
import com.lhy.resultcrud.entities.Department;
import com.lhy.resultcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

/**
 * 员工控制类
 */
@Controller
@RequestMapping(value = "/emp")
public class EmpController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @Autowired
    DepartmentMapper departmentMapper;
    /**
     * 打开员工管理界面
     *
     * @return
     */
    @GetMapping(value = "/openEmpView")
    public String openEmpView(Map map) {
        map.put("emps", employeeDao.getAll());
        return "emp/empMgr";
    }

    /**
     * to 员工新增界面
     *
     * @param model
     * @return
     */
    @GetMapping(value = "/toAddEmpView")
    public String toAddEmpView(Model model) {
        //来到添加页面,查出所有的部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/addEmp";
    }

    /**
     * 保存员工
     *
     * @param employee
     * @return
     */
    @PostMapping(value = "/saveEmp")
    public String saveEmp(Employee employee) {
        System.out.println("添加的员工数据：" + employee);
        employeeDao.save(employee);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/emp/openEmpView";
    }

    @GetMapping(value = "/toEmpUpdateView/{id}")
    public String toEmpUpdateView(@PathVariable(value = "id") Integer id, Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        return "emp/addEmp";
    }

    //员工修改；需要提交员工id；
    @PutMapping("/saveEmp")
    public String updateEmployee(Employee employee) {
        System.out.println("修改的员工数据：" + employee);
        employeeDao.save(employee);
        return "redirect:/emp/openEmpView";
    }

    @DeleteMapping(value = "/deleteEmp/{id}")
    public String deleteEmp(@PathVariable(value = "id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emp/openEmpView";
    }

    @ResponseBody
    @GetMapping("/getDept/{id}")
    public Department getDept(@PathVariable Integer id){
        return departmentMapper.getDepartment(id);
    }
}
