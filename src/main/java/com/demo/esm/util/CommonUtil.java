package com.demo.esm.util;

import com.demo.esm.common.ESMConstants;
import com.demo.esm.common.ESMValidationException;
import com.demo.esm.model.Employee;
import com.demo.esm.model.EmployeeFilter;
import org.springframework.util.StringUtils;

public class CommonUtil {
    public static Employee validateEmployee(String line) throws ESMValidationException {
        Employee employee = new Employee();
        if (!StringUtils.isEmpty(line) && !line.startsWith(ESMConstants.LINE_COMMENT)) {
            String[] columns = line.split(ESMConstants.LINE_SEPERATOR);
            if (columns.length == 4) {
                double salary = Double.parseDouble(columns[3]);
                if (salary < 0) {
                    throw new ESMValidationException("Salary should be >= 0");
                }
                employee.setId(columns[0]);
                employee.setLogin(columns[1]);
                employee.setName(columns[2]);
                employee.setSalary(salary);

                return employee;
            }
        }
        throw new ESMValidationException(line);
    }

    public static boolean validateEmployeeFilter(EmployeeFilter filter) {
        return (filter.getMinSalary() >= 0 &&
                filter.getMaxSalary() >= 0 &&
                filter.getMaxSalary() > filter.getMinSalary()) &&
                filter.getOffset() >= 0 &&
                filter.getLimit() > 0 &&
                filter.getSort() != null &&
                (filter.getSort().startsWith(ESMConstants.SORT_ASSENDING) || filter.getSort().startsWith(ESMConstants.SORT_DESENDING));
    }
}
