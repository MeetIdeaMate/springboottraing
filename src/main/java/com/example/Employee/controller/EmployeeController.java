package com.example.Employee.controller;

import com.example.Employee.model.Employee;
import com.example.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Employee.request.EmployeePostRequest;

@RestController
@RequestMapping("/employee")
public class EmployeeController
{

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity createEmployee(@RequestBody EmployeePostRequest employeePostRequest){
        Employee employee = employeeService.createEmployee(employeePostRequest);
        return ResponseEntity.status(201).body(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity getEmployeeById(@PathVariable int id){
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.status(200).body(employee);
    }
    @PutMapping("/{id}")
    public ResponseEntity putEmployeeId(@PathVariable int id,@RequestBody EmployeePostRequest employeePostRequest)
    {
        Employee employee = employeeService.putEmployeeById(id,employeePostRequest);
        return  ResponseEntity.status(200).body(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployeeById(@PathVariable int id){
        return null;
    }




}
