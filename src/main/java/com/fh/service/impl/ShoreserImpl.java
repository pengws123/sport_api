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

    @Override
    public void saveshore(ShoreXian shore) {
        shoreDao.saveshore(shore);
    }

    @Override
    public void deleteshore(Integer id) {
        shoreDao.deleteshore(id);
    }

    @Override
    public ShoreXian queryshoreId(Integer id) {
        ShoreXian shore =shoreDao.queryshoreId(id);
        return shore;
    }
}
