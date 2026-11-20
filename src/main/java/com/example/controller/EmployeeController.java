package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;

  
    @PostMapping
    public Employee insert(@RequestBody Employee employee) {
        return service.insert(employee);
    }

    // Get All Employees
    @GetMapping
    public List<Employee> getAll() {
        return service.allEmployees();
    }

    // Get Employee By ID
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return service.getEmployee(id);
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteEmployee(id);
       
    }
    @PutMapping("/{id}")
    public Employee update(@PathVariable int id,@RequestBody Employee employee) {
    	return service.updateEmployee(id, employee);
    }
}
