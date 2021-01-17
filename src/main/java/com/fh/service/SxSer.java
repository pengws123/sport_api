package com.fh.service;

import com.fh.entity.po.SxValue;

import java.util.List;

public interface SxSer {
    List<SxValue> querysxvalue();

    void savexvalue(SxValue sx);

    void delxvalue(Integer id);
}
