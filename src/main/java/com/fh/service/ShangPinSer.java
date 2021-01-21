package com.fh.service;

import com.fh.entity.po.Productvalue;
import com.fh.entity.po.ShangPin;
import com.fh.entity.vo.Paramss;

import java.util.List;
import java.util.Map;

public interface ShangPinSer {

    void delshangpin(Integer id);

    ShangPin selectshangpin(Integer id);

    void updateshangpin(ShangPin shan);

    void savesshangpin(ShangPin shan, String attr, String sku);

    Map queryShang(Paramss param);

    List<Productvalue> selectByPerId(Integer proId);
}
