package com.fh.service.impl;

import com.fh.dao.SpnameDao;
import com.fh.entity.po.SporyName;
import com.fh.entity.vo.Paramss;
import com.fh.service.SpNaSer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SpNaSerImpl implements SpNaSer {
    @Resource
    private SpnameDao spmaDao;

    @Override
    public Map queryspname(Paramss param) {
        Map rs = new HashMap();
        Integer count=spmaDao.querycount(param);
        rs.put("count",count);
        List<SporyName> list = spmaDao.queryspname(param);
        rs.put("list",list);
        return rs;
    }

    @Override
    public void delspname(Integer id) {
        spmaDao.delspname(id);
    }

    @Override
    public SporyName selectspname(Integer id) {
        SporyName sp= spmaDao.selectspname(id);
        return sp;
    }

    @Override
    public void updatespname(SporyName spname) {
        spmaDao.updatespname(spname);
    }

    @Override
    public void savespname(SporyName spname) {
        spmaDao.savespname(spname);
    }
}
