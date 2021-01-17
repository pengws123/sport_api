package com.fh.dao;

import com.fh.entity.po.SportType;

import java.util.Date;
import java.util.List;

public interface SpoDao {
    List<SportType> getData();

    List<SportType> getDataByPid(Integer pid);

    void add(SportType spo);
    /*
    *
    * */

    Integer selected(Date createDate);

    SportType updateById(Integer id);

    Integer update(SportType spo);

    void delsorp(Integer id);
}
