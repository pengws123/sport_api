package com.fh.service;

import com.fh.entity.po.Userjuese;
import com.fh.entity.vo.Paramss;

import java.util.Map;

public interface UserjueseSer {
    Map queryspoper(Paramss param);

    void savejuese(Userjuese juese);

    void deletejuese(Integer id);

    Userjuese selectjuese(Integer id);
}
