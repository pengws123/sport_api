package com.fh.service;

import com.fh.entity.po.SportType;

import java.util.List;

public interface SpoSer {
    List<SportType> getData();

    List<SportType> getDataByPid(Integer pid);

    Integer add(SportType spo);

    SportType updateById(Integer id);

    void update(SportType spo);

    void delsorp(Integer id);
}
