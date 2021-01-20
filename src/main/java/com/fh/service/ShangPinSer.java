package com.fh.service;

import com.fh.entity.po.ShangPin;

public interface ShangPinSer {
    void savesshangpin(ShangPin shan);

    void delshangpin(Integer id);

    ShangPin selectshangpin(Integer id);

    void updateshangpin(ShangPin shan);
}
