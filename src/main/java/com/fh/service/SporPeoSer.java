package com.fh.service;

import com.fh.entity.po.SporPeoper;
import com.fh.entity.vo.Paramss;

import java.util.Map;

public interface SporPeoSer {
    Map queryspoper(Paramss param);

    void delspoper(Integer id);

    void savespoper(SporPeoper spore);

    SporPeoper selectById(Integer id);

    void updatespor(SporPeoper spor);
}
