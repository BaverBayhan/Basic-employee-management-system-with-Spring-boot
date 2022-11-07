package com.CRMproject.Controller;

import com.CRMproject.Entity.Employee;
import com.CRMproject.Service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        return new ResponseEntity<Employee>(service.getEmployeeById(id),HttpStatus.OK);
    }

    @GetMapping()
    public List<Employee> getAllEmployees()
    {
        return service.getAllEmployees();
    }

    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
    {
        return new ResponseEntity<Employee>(service.setEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employee)
    {
        return new ResponseEntity<>(service.updateEmployee(employee,id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable long id)
    {
        return new ResponseEntity<>(service.deleteEmployeeById(id),HttpStatus.OK);
    }

}
