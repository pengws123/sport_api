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
import sun.nio.cs.ext.MacArabic;

import javax.annotation.Resource;
import java.beans.Transient;
import java.util.*;

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
        //处理新增的sku 和   spu  的方法
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

    @Override
    public List<Productvalue> selectByPerId(Integer proId) {
        List<Productvalue> list = productvalueDao.selectByPerId(proId);

        return list;
    }
    //处理 sku  spu  table 回显的方法
    @Override
    public Map selectSkuByProId(Integer proId) {
        Map data =  new HashMap();
        List<Productvalue> list = productvalueDao.selectByPerId(proId);
        Map skuData=new HashMap();
        Map attrData=new HashMap();
        Map tableData=new HashMap();
        List <JSONObject> tableList=new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            Productvalue productvalue = list.get(i);
            if(productvalue.getPrice()!=null){
                JSONObject jsonObject = JSONObject.parseObject(productvalue.getAttrData());
                Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
                for (Map.Entry<String, Object> entry : entries) {
                    String key = entry.getKey();
                    Set o = (Set) skuData.get(key);
                if(o!=null){
                    o.add(entry.getValue());
                }else {
                    //创建一个set 集合
                    Set valuesSet =new HashSet();
                    valuesSet.add(entry.getValue());
                    skuData.put(key,valuesSet);
                }
                }
                //表格属性放入list
                tableList.add(jsonObject);
            }else {
                JSONObject json = JSONObject.parseObject(productvalue.getAttrData());
                Set<Map.Entry<String, Object>> entries = json.entrySet();
                for (Map.Entry<String, Object> entry : entries) {
                    attrData.put(entry.getKey(),entry.getValue());
                }
            }
        }
        //将sku 和attr 放入返回值中
        data.put("skudata",skuData);
        data.put("attrdata",attrData);
        data.put("tableData",tableList);
        return data;
    }
}
