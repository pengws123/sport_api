package com.fh.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fh.dao.ProductvalueDao;
import com.fh.dao.ShangPinDao;
import com.fh.entity.po.Productvalue;
import com.fh.entity.po.ShangPin;
import com.fh.entity.vo.Paramss;
import com.fh.service.ShangPinSer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.beans.Transient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShangPinSerImpl implements ShangPinSer {

    @Resource
    private ShangPinDao shangPinDao;

    @Resource
    private ProductvalueDao productvalueDao;
    @Override
    public void delshangpin(Integer id) {
        shangPinDao.delshangpin(id);
    }

    @Override
    public ShangPin selectshangpin(Integer id) {
        ShangPin san= shangPinDao.selectshangpin(id);

        return san;
    }

    @Override
    public void updateshangpin(ShangPin shan) {
        shangPinDao.updateshangpin(shan);
    }

    @Override
    @Transactional
    public void savesshangpin(ShangPin shan, String attr, String sku) {

        shangPinDao.savesshangpin(shan);
        List<Productvalue> plist = new ArrayList<>();

        JSONArray objects = JSONObject.parseArray(attr);

        for (int i = 0; i <objects.size() ; i++) {

            Productvalue pr =new Productvalue();
            pr.setProId(shan.getId());

            pr.setAttrData(objects.get(i).toString());
            plist.add(pr);
        }

        JSONArray objectsku = JSONObject.parseArray(sku);


        for (int i = 0; i < objectsku.size(); i++) {
            JSONObject jsonb = (JSONObject) objectsku.get(i);

            Productvalue pr =new Productvalue();
            pr.setProId(shan.getId());
            pr.setPrice(jsonb.getDouble("jiage"));
            pr.setStorcks(jsonb.getInteger("kucun"));
            jsonb.remove("jiage");
            jsonb.remove("kucun");
            pr.setAttrData(objectsku.get(i).toString());
            plist.add(pr);
        }
        productvalueDao.saveProductvalueDate(plist);
    }

    @Override
    public Map queryShang(Paramss param) {

        Map rs = new HashMap();
        Integer count=shangPinDao.querycount(param);
        rs.put("count",count);
        List<ShangPin> list=shangPinDao.queryShang(param);
        rs.put("list",list);

        return rs;
    }
}
