package com.fh.dao;

import com.fh.entity.po.SxValue;

import java.util.List;

public interface SxDao {
    List<SxValue> querysxvalue();

    void savexvalue(SxValue sx);
}
