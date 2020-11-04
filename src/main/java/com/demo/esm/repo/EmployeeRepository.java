package com.demo.esm.repo;

import com.demo.esm.model.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, String> {
    List<Employee> findEmployeesBySalaryBetween(double minSalary, double maxSalary, Pageable pageable);
}
