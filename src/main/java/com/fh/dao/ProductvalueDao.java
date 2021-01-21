package com.fh.dao;

import com.fh.entity.po.Productvalue;

import java.util.List;

public interface ProductvalueDao {
    void saveProductvalueDate(List<Productvalue> plist);

    List<Productvalue> selectByPerId(Integer proId);
}
