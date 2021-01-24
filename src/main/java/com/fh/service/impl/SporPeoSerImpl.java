package com.fh.service.impl;

import com.fh.dao.SporPeoperDao;
import com.fh.dao.SxDao;
import com.fh.entity.po.SporPeoper;
import com.fh.entity.po.SxValue;
import com.fh.entity.vo.Paramss;
import com.fh.service.SporPeoSer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SporPeoSerImpl implements SporPeoSer {
    @Resource
    private SporPeoperDao sporpeDa;
    @Resource
    private SxDao sxDao;
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

    @Override
    public Map queryByTypeIds(Integer typeId) {
        Map map = new HashMap();
        //查询出所有的属性数据
       List<SporPeoper> lis= sporpeDa.queryByTypeID(typeId);
        //声明skuDatas
        List<SporPeoper> skuDats=new ArrayList<>();
        //声明attrDatas
        List<SporPeoper> attrDatas=new ArrayList<>();
        //遍历集合
        for (int i = 0; i <lis.size() ; i++) {
            SporPeoper sp= lis.get(i);
            if(sp.getIsSKU()==1){
                if(sp.getType()!=3){
                    List<SxValue> sxValue = sxDao.selectByIds(sp.getId());
                    sp.setValues(sxValue);
                }
                skuDats.add(sp);
            }else {
                if(sp.getType()!=3){
                    List<SxValue> sxValue = sxDao.selectByIds(sp.getId());
                    sp.setValues(sxValue);
                }
                attrDatas.add(sp);
            }
        }
        //查询sku数据
        map.put("skuDatas",skuDats);
        //非sku数据
        map.put("attrDatas",attrDatas);
        return map;
    }


}
