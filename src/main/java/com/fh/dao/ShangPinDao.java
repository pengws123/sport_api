package com.fh.dao;

import com.fh.entity.po.ShangPin;
import com.fh.entity.vo.Paramss;

import java.util.List;

public interface ShangPinDao {
    void savesshangpin(ShangPin shan);

    void delshangpin(Integer id);

    ShangPin selectshangpin(Integer id);

    void updateshangpin(ShangPin shan);

    Integer querycount(Paramss param);

    List<ShangPin> queryShang(Paramss param);
}
