package com.fh.service;

import com.fh.entity.po.SporyName;
import com.fh.entity.vo.Paramss;

import java.util.Map;

public interface SpNaSer {
    Map queryspname(Paramss param);

    void delspname(Integer id);

    SporyName selectspname(Integer id);

    void updatespname(SporyName spname);

    void savespname(SporyName spname);
}
