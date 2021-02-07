package com.fh.dao;

import com.fh.entity.po.SporPeoper;
import com.fh.entity.po.Userjuese;
import com.fh.entity.vo.Paramss;

import java.util.List;

public interface UserjueseDao {
    Integer querycount(Paramss param);

    List<SporPeoper> queryjuese(Paramss param);

    void savejuese(Userjuese juese);
}
