package com.fh.dao;

import com.fh.entity.po.ShangPin;

public interface ShangPinDao {
    void savesshangpin(ShangPin shan);

    void delshangpin(Integer id);

    ShangPin selectshangpin(Integer id);
}
