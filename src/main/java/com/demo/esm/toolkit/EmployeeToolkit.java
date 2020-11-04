package com.demo.esm.toolkit;

import com.demo.esm.common.ESMValidationException;
import com.demo.esm.model.Employee;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static com.demo.esm.util.CommonUtil.validateEmployee;

@Component
@Scope("singleton")
public class EmployeeToolkit {

    public List<Employee> transformFileToList(MultipartFile file) {
        List<Employee> employeeList = new ArrayList<Employee>();
        try {
            new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8)).lines().skip(1).forEach(line -> {
                employeeList.add(validateEmployee(line));
            });
        } catch (IOException e) {
            System.out.println(e);
        } catch (ESMValidationException e) {
            return new ArrayList<Employee>();
        }
        return employeeList;
    }
}
