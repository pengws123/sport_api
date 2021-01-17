package com.fh.service;

import com.fh.entity.po.SxValue;

import java.util.List;

public interface SxSer {

    void savexvalue(SxValue sx);

    void delxvalue(Integer id);

    List<SxValue> querysxvalue(Integer attId);

    SxValue selectById(Integer id);
}
