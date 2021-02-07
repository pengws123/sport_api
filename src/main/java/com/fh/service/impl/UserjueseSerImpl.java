package com.fh.service.impl;

import com.fh.dao.UserjueseDao;
import com.fh.entity.po.SporPeoper;
import com.fh.entity.po.Userjuese;
import com.fh.entity.vo.Paramss;
import com.fh.service.UserjueseSer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserjueseSerImpl implements UserjueseSer {
    @Resource
    private UserjueseDao userjueseDao;

    @Override
    public Map queryspoper(Paramss param) {
        Map rs =new HashMap();
        Integer count=userjueseDao.querycount(param);
        rs.put("count",count);
        List<SporPeoper> list = userjueseDao.queryjuese(param);
        rs.put("list",list);
        return rs;
    }

    @Override
    public void savejuese(Userjuese juese) {
        userjueseDao.savejuese(juese);
    }
}
