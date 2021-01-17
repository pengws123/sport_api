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
    public List<SxValue> querysxvalue() {
        List<SxValue> list=sxDao.querysxvalue();
        return list;
    }
}
