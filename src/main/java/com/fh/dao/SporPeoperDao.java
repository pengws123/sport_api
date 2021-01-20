package com.fh.dao;

import com.fh.entity.po.SporPeoper;
import com.fh.entity.vo.Paramss;

import java.util.List;

public interface SporPeoperDao {
    Integer querycount(Paramss param);

    List<SporPeoper> queryspoper(Paramss param);

    void delspoper(Integer id);

    void savespoper(SporPeoper spore);

    SporPeoper selectById(Integer id);

    void updatespor(SporPeoper spor);

    List<SporPeoper> getData();

    List<SporPeoper> queryByTypeID(Integer typeId);
}
