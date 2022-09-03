package com.example.Employee.service;

import com.example.Employee.model.Employee;
import com.example.Employee.request.EmployeePostRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    public static final List<Employee> employeeList = new ArrayList<>();

    @Override
    public Employee createEmployee(EmployeePostRequest employeePostRequest) {
        Employee employee = new Employee();
        employee.setName(employeePostRequest.getName());
        employee.setDesigination(employeePostRequest.getDesignation());
        employee.setDob(employeePostRequest.getDob());
        employee.setId(employeeList.size() + 1);
        boolean ismajor=findMajorOrNot(employeePostRequest.getDob());
        employee.setMajor(ismajor);


        employeeList.add(employee);

        return employee;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employeeRes = null;
        for(Employee employee: employeeList){
            if(employee.getId() == id){
                employeeRes = employee;
                break;
            }
        }
        return employeeRes;
    }

    @Override
    public Employee putEmployeeById(int id, EmployeePostRequest employeePostRequest) {
        Employee employeeRes=null;
        int i=0;
        for(Employee employee: employeeList)
        {

            if(employee.getId()==id)
            {
                employeeRes=employee;
                break;
            }
            i++;
        }
        employeeList.remove(employeeRes);
        Employee nemployee=new Employee();
        nemployee.setId(id);
        nemployee.setName(employeePostRequest.getName());
        nemployee.setDesigination(employeePostRequest.getDesignation());
        nemployee.setDob(employeePostRequest.getDob());
        boolean ismajor=findMajorOrNot(employeePostRequest.getDob());
        nemployee.setMajor(ismajor);

        employeeList.add(i,nemployee);
        return nemployee;

    }

    @Override
    public String deleteEmployeeById(int id) {
        return null;
    }

    private boolean findMajorOrNot(LocalDate dob){
        int age =  Period.between(dob, LocalDate.now()).getYears();
        if(age > 18){
          return true;
        }else {
            return false;
        }

    }
}
