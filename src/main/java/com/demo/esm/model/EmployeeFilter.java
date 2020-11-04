package com.demo.esm.model;

import com.demo.esm.common.ESMConstants;
import org.springframework.data.domain.Sort;

public class EmployeeFilter {
    private double minSalary;
    private double maxSalary;
    private int offset;
    private int limit;
    private String sort;

    public EmployeeFilter() {
    }

    public EmployeeFilter(double minSalary, double maxSalary, int offset, int limit, String sort) {
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.offset = offset;
        this.limit = limit;
        this.sort = sort;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Sort.Direction getSortingDirection() {
        if (sort.startsWith(ESMConstants.SORT_ASSENDING)) {
            return Sort.Direction.ASC;
        } else {
            return Sort.Direction.DESC;
        }
    }

    public String getSortingProperty(){
        return sort.substring(1);
    }
}
