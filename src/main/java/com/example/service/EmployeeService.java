
package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeDao;
import com.example.entity.Employee;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao dao;

  
    public Employee insert(Employee employee) {
        return dao.save(employee);
    }

    // Get All Employees
    public List<Employee> allEmployees() {
        return dao.findAll();
    }

    // Get Employee By ID
    public Employee getEmployee(int id) {
        return dao.findById(id).orElse(null);
    }

    // Delete Employee
    public void deleteEmployee(int id) {
        dao.deleteById(id);
    }
    
    public Employee updateEmployee(int id,Employee employee) {
    	Employee emp = dao.findById(id).orElse(null);
    	if(emp!=null) {
    		emp.setEmail(employee.getEmail());
    		emp.setName(employee.getName());
    		emp.setSalary(employee.getSalary());
    		return dao.save(emp);
    	}
		return null;
    	
    	
    }
}
