package com.CRMproject.Service;

import com.CRMproject.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee setEmployee(Employee employee);
    public Employee getEmployeeById(long id);
    List<Employee> getAllEmployees();

    public Employee updateEmployee(Employee employee,long id);

    public String deleteEmployeeById(long id);
}
