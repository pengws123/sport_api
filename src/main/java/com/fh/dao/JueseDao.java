package com.fh.dao;

import com.fh.entity.po.Juese;

import java.util.List;

public interface JueseDao {
    List<Juese> queryuserjue(Integer uid);

    void deletejuese(Integer uid);

    void saveuserjue(List<Juese> list);
}
