package com.demo.esm.controller;

import com.demo.esm.model.Employee;
import com.demo.esm.model.EmployeeFilter;
import com.demo.esm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")//Added to test with the angular application
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(propagation = Propagation.SUPPORTS)
    public ResponseEntity<List<Employee>> getEmployees(EmployeeFilter filter) {
        return employeeService.getEmployees(filter);
    }

    @PostMapping(value = "/users/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseEntity addEmployees(@RequestParam("file") MultipartFile file) {
        return employeeService.addEmployees(file);
    }
}
