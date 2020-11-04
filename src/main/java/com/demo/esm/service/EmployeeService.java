package com.demo.esm.service;

import com.demo.esm.model.Employee;
import com.demo.esm.model.EmployeeFilter;
import com.demo.esm.repo.EmployeeRepository;
import com.demo.esm.toolkit.EmployeeToolkit;
import com.demo.esm.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeToolkit employeeToolkit;

    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseEntity getEmployees(EmployeeFilter filter) {
        boolean isValidCriteria = CommonUtil.validateEmployeeFilter(filter);

        if (isValidCriteria) {
            List<Employee> employeeList = new ArrayList<Employee>();
            Pageable pageable = PageRequest.of(filter.getOffset(), filter.getLimit(), filter.getSortingDirection(), filter.getSortingProperty());
            employeeRepository.findEmployeesBySalaryBetween(filter.getMinSalary(), filter.getMaxSalary(), pageable).forEach(employeeList::add);
            return new ResponseEntity(employeeList, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity addEmployees(MultipartFile file) {
        List<Employee> employeeList = employeeToolkit.transformFileToList(file);
        if (employeeList.size() > 0) {
            employeeRepository.saveAll(employeeList);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }


}
