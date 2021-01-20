package com.fh.service.impl;

import com.fh.dao.SporPeoperDao;
import com.fh.entity.po.SporPeoper;
import com.fh.entity.vo.Paramss;
import com.fh.service.SporPeoSer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SporPeoSerImpl implements SporPeoSer {
    @Resource
    private SporPeoperDao sporpeDa;

    @Override
    public Map queryspoper(Paramss param) {
        Map rs =new HashMap();
        Integer count=sporpeDa.querycount(param);
        rs.put("count",count);
        List<SporPeoper> list = sporpeDa.queryspoper(param);
        rs.put("list",list);
        return rs;
    }

    @Override
    public void delspoper(Integer id) {
        sporpeDa.delspoper(id);
    }

    @Override
    public void savespoper(SporPeoper spore) {
        sporpeDa.savespoper(spore);
    }

    @Override
    public SporPeoper selectById(Integer id) {
        SporPeoper pe =sporpeDa .selectById(id);
        return pe;
    }

    @Override
    public void updatespor(SporPeoper spor) {
        sporpeDa.updatespor(spor);
    }

    @Override
    public List<SporPeoper> getData() {
        List<SporPeoper> sp= sporpeDa.getData();
        return sp;
    }

    @Override
    public List<SporPeoper> queryByTypeID(Integer typeId) {
        List<SporPeoper> list = sporpeDa.queryByTypeID(typeId);
        return list;
    }
}
