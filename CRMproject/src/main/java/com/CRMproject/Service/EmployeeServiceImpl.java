package com.CRMproject.Service;

import com.CRMproject.Entity.Employee;
import com.CRMproject.Repository.EmployeeRepository;
import com.CRMproject.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository repository;

    @Override
    public Employee setEmployee(Employee employee) {
        repository.save(employee);
        return  employee;
    }

    @Override
    public Employee getEmployeeById(long id) {
        return repository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Employee","id",id));
    }
    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existing_employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id","Employee",id));
        existing_employee.setFirst_name(employee.getFirst_name());
        existing_employee.setLast_name(employee.getLast_name());
        existing_employee.setE_mail(employee.getE_mail());
        repository.save(existing_employee);
        return existing_employee;
    }

    @Override
    public String deleteEmployeeById(long id) {
        Optional<Employee> employee = repository.findById(id);
        if(employee.isPresent())
        {
            repository.deleteById(id);
            return "Delete operation is successful";
        }
        else {
            throw new ResourceNotFoundException("id","Employee",id);
        }
    }
}
