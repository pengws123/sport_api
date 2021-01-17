package com.fh.dao;

import com.fh.entity.po.SporyName;
import com.fh.entity.vo.Paramss;

import java.util.List;

public interface SpnameDao {
    Integer querycount(Paramss param);

    List<SporyName> queryspname(Paramss param);

    void delspname(Integer id);

    SporyName selectspname(Integer id);

    void updatespname(SporyName spname);

    void savespname(SporyName spname);
}
