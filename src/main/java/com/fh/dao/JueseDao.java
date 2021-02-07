package com.fh.dao;

import com.fh.entity.po.Juese;

import java.util.List;

public interface JueseDao {
    List<Juese> queryuserjue(Integer uid);
}
