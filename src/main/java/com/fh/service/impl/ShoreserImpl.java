package com.fh.service.impl;

import com.fh.dao.ShoreDao;
import com.fh.entity.po.ShoreXian;
import com.fh.service.Shoreser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShoreserImpl implements Shoreser {
    @Resource
    private ShoreDao shoreDao;

    @Override
    public List<ShoreXian> getshore() {

        List<ShoreXian> list=shoreDao.getshore();
        return list;
    }
}
