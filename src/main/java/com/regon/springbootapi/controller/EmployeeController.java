package com.regon.springbootapi.controller;

import com.regon.springbootapi.model.Employee;
import com.regon.springbootapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> get(){
        return employeeService.get();
    }

    @PostMapping("/employee")
    public Employee save(@RequestBody Employee employeeObj) {
        employeeService.save(employeeObj);
        return employeeObj;
    }

    @GetMapping("/employee/{id}")
    public Employee get(@PathVariable int id) {
        Employee employeeObj = employeeService.get(id);
        if (employeeObj == null) {
            throw new RuntimeException("Employee with id:"+id+" is not found");
        }

        return employeeObj;
    }

    @DeleteMapping("/employee/{id}")
    public String delete(@PathVariable int id) {
        employeeService.delete(id);
        return "Employee deleted with id:"+id;
    }

    @PutMapping("/employee")
    public Employee update(@RequestBody Employee employeeObj) {
        employeeService.save(employeeObj);
        return employeeObj;
    }
}
