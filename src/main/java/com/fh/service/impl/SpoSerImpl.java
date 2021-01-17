package com.fh.service.impl;

import com.fh.dao.SpoDao;
import com.fh.entity.po.SportType;
import com.fh.service.SpoSer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpoSerImpl implements SpoSer {
    @Resource
    private SpoDao spoDao;

    @Override
    public List<SportType> getData() {
        List<SportType> list=spoDao.getData();
        return list;
    }

    @Override
    public List<SportType> getDataByPid(Integer pid) {
        List<SportType> list=spoDao.getDataByPid(pid);
        return list;
    }

    @Override
    public Integer add(SportType spo) {
        spoDao.add(spo);

        Integer sp= spoDao.selected(spo.getCreateDate());
        return sp;
    }

    @Override
    public SportType updateById(Integer id) {
        SportType sp = spoDao.updateById(id);
        return sp;
    }

    @Override
    public void update(SportType spo) {
        spoDao.update(spo);
    }

    @Override
    public void delsorp(Integer id) {
        spoDao.delsorp(id);
    }
}
