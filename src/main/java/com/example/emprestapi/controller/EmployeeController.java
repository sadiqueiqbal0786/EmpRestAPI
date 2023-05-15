package com.example.emprestapi.controller;

import com.example.emprestapi.entity.Employee;
import com.example.emprestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/employee")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee1=employeeService.findById(id);
        if(employee1 == null){
            throw new RuntimeException("Exception"+id);

        }
        return employee1;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee employee1 = employeeService.save(employee);
        return employee1;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee employee1=employeeService.save(employee);
        return employee1;
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee=employeeService.findById(id);
        if(employee==null)
             throw new RuntimeException("not available" + id);
        employeeService.deleteById(id);
        return "Deleted id is "+id;
    }

}
