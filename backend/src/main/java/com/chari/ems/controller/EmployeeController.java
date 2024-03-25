package com.chari.ems.controller;

import com.chari.ems.model.Employee;
import com.chari.ems.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    public EmployeeRepository employeeRepository;

    //Get all employees
    @GetMapping("/employees")
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    //create employee
    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    //Update employee by employee id
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable String id, @RequestBody Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(NullPointerException::new);

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());

        Employee updateEmployee = employeeRepository.save(employee);
        return updateEmployee;
    }

    //Delete employee
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable String id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(NullPointerException::new);

        employeeRepository.delete(employee);
        return "Employee Deleted!";
    }

    //Get employee details by employee id
    @GetMapping("/employee/{id}")
    public Employee employeeDetails(@PathVariable String id) {
        return employeeRepository.findById(id)
                .orElseThrow(NullPointerException::new);
    }

}
