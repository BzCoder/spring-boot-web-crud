package com.example.springbootwebcrud.controller;

import com.example.springbootwebcrud.dao.DepartmentDao;
import com.example.springbootwebcrud.dao.EmployeeDao;
import com.example.springbootwebcrud.entities.Department;
import com.example.springbootwebcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * 员工管理类
 *
 * @author BaoZhou
 * @date 2018/5/17
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    /**
     * @return 返回员工列表
     */
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        System.out.println("员工信息：" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        model.addAttribute("emp", employee);
        return "emp/add";
    }


    @PutMapping("/emp")
    public String updateEmployee(Employee employee)
    {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String toDeletePage(@PathVariable("id") Integer id, Model model) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
