package com.example.Employee.service;

import com.example.Employee.model.Employee;
import com.example.Employee.request.EmployeePostRequest;

public interface EmployeeService {
    Employee createEmployee(EmployeePostRequest employeePostRequest);

    Employee getEmployeeById(int id);

    Employee putEmployeeById(int id, EmployeePostRequest employeePostRequest);

    String deleteEmployeeById(int id);
}
