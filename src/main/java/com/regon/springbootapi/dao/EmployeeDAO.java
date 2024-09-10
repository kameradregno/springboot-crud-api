package com.regon.springbootapi.dao;

import com.regon.springbootapi.model.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> get();
    Employee get(int id);
    void save (Employee employee);
    void delete(int id);

}
