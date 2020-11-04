package com.demo.esm.util;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public class FilterPageRequest implements Pageable {
    private int offset;
    private int limit;
    private Sort sort;

    public FilterPageRequest(int offset, int limit, Sort.Direction direction, List<String> property) {
        this.offset = offset;
        this.limit = limit;
//        sort = new Sort();
    }

    @Override
    public int getPageNumber() {
        return offset / limit;
    }

    @Override
    public int getPageSize() {
        return limit;
    }

    @Override
    public long getOffset() {
        return offset;
    }

    @Override
    public Sort getSort() {
        return sort;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }
}
