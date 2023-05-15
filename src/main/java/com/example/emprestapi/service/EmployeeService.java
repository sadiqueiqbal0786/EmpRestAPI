package com.example.emprestapi.service;

import com.example.emprestapi.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
