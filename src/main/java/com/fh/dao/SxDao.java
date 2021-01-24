package com.fh.dao;

import com.fh.entity.po.SxValue;

import java.util.List;

public interface SxDao {
    List<SxValue> querysxvalue(Integer attId);

    void savexvalue(SxValue sx);

    void delxvalue(Integer id);

    SxValue selectById(Integer id);

    void updatexvalue(SxValue sx);

    List<SxValue> selectByIds(Integer id);
}
