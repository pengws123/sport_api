package com.fh.service.impl;

import com.fh.dao.ShangPinDao;
import com.fh.entity.po.ShangPin;
import com.fh.service.ShangPinSer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShangPinSerImpl implements ShangPinSer {

    @Resource
    private ShangPinDao shangPinDao;

    @Override
    public void savesshangpin(ShangPin shan) {
        shangPinDao.savesshangpin(shan);
    }

    @Override
    public void delshangpin(Integer id) {
        shangPinDao.delshangpin(id);
    }

    @Override
    public ShangPin selectshangpin(Integer id) {
        ShangPin san= shangPinDao.selectshangpin(id);

        return san;
    }
}
