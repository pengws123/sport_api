package com.fh.service.impl;

import com.fh.dao.SxDao;
import com.fh.entity.po.SxValue;
import com.fh.service.SxSer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SxSerImpl implements SxSer {
    @Resource
    private SxDao sxDao;

    @Override
    public List<SxValue> querysxvalue(Integer attId) {
        List<SxValue> list=sxDao.querysxvalue(attId);
        return list;
    }

    @Override
    public SxValue selectById(Integer id) {
        SxValue sx= sxDao.selectById(id);

        return sx;
    }

    @Override
    public void savexvalue(SxValue sx) {
        sxDao.savexvalue(sx);
    }

    @Override
    public void delxvalue(Integer id) {
        sxDao.delxvalue(id);
    }


}
