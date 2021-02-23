package com.fh.controller;

import com.fh.entity.po.SporPeoper;
import com.fh.entity.vo.Paramss;
import com.fh.entity.vo.ResponseData;
import com.fh.service.SporPeoSer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/perpor")
public class SporPeoperContro {
    @Resource
    private SporPeoSer sporper;
    /*
     * 查询属性名字信息
     * 路径： http://localhost:8080/api/perpor/queryspoper
     * 请求方式 get
     *
     * 参数
     *
     *
     *
     * start （当前页）  （必选）
     *
     * size （每页条数） （必选）
     *bandE     (首字母)
     * name   (按照名字准确查询)  （可选项）
     *ord       (排序)
     * birthdaymin   生产时间  最小值  （可选）
     *
     * birthdaymax   生产时间 最大值  （可选）
     *
     *
     * 返回值
     *  code  info   date:{list  count}
     *
     * */
    @GetMapping("queryspoper")
    public ResponseData queryspoper(Paramss param){
        if(param.getStart()==null){
            return ResponseData.error(400,"起始小标不能为空");
        }
        if(param.getSize()==null){
            return ResponseData.error(400,"每页条数不能为空");
        }
        Map map = sporper.queryspoper(param);
        return ResponseData.success(map);
    }
    /*
     * 删除属性信息
     * 路径：  http://localhost:8080/api/perpor/delspoper
     * 请求方式 post
     *
     * 参数
     *  Integer 类型 id （
     *
     *返回值  code  info
     * */
    @PostMapping("delspoper")
    public  ResponseData delspoper(Integer id){
        if(id==null){
            return ResponseData.error(400,"起始小标不能为空");
        }
        sporper.delspoper(id);
        return ResponseData.success(null);
    }
    /*
     * 新增商品信息
     * 路径： http://localhost:8080/api/perpor/savespoper
     * 请求方式 post
     *
     * 参数
     *  SporPeoper   对象
     *
     *  返回值  code  info
     * */
    @PostMapping("savespoper")
    public  ResponseData savespoper (SporPeoper spore){
        if(spore==null){
            return ResponseData.error(400,"起始小标不能为空");
        }
        spore.setIsDel(0);
        spore.setCreateDate(new Date());
        sporper.savespoper(spore);
        return ResponseData.success(null);
    }
    /*
     * 根据id查询属性名字信息
     * 路径： http://localhost:8080/api/perpor/selectById
     * 请求方式 post
     *
     * 参数
     *  Integer 类型 id
     *
     *  返回值  code  info  data;{data:na}
     * */
    @PostMapping("selectById")
    public  ResponseData selectById(Integer id){
        if(id==null){
            return ResponseData.error(400,"起始小标不能为空");
        }
        SporPeoper pe= sporper.selectById(id);
        return ResponseData.success(pe);
    }
    /*
     * 修改商品信息
     * 路径： http://localhost:8080/api/perpor/updatespor
     * 请求方式 post
     *
     * 参数
     *  SporPeoper   对象
     *
     *  返回值  code  info
     * */
    @PostMapping("updatespor")
    public  ResponseData updatespor(SporPeoper spor){
        if(spor==null){
            return ResponseData.error(400,"起始小标不能为空");
        }
        spor.setUpdateDate(new Date());
        sporper.updatespor(spor);
        return ResponseData.success(null);
    }
    /*    查询所有的分类数据
        路径   http://localhost:8080/api/perpor/getData

        get请求

                参数

        返回值   {"code":200,"inif":"提示",data:[{*}]}*/
    @GetMapping("getData")
    public ResponseData getData(){

        List<SporPeoper> spor= sporper.getData();
        return ResponseData.success(spor);
    }
    /*    根据typeid查询所有的分类数据
        路径   http://localhost:8080/api/perpor/queryByTypeID

        get请求

              typeid  参数

        返回值   {"code":200,"inif":"提示",data:[{*}]}*/
    @GetMapping("queryByTypeID")
    public  ResponseData queryByTypeID(Integer typeId){
        if(typeId==null){
            return ResponseData.error(400,"参数不能为空");
        }

        List<SporPeoper>list=sporper.queryByTypeID(typeId);
        return ResponseData.success(list);
    }

     /*    根据typeid查询所有的分类数据
        路径   http://localhost:8080/api/perpor/queryByTypeIds

        get请求

              typeid  参数

        返回值   {"code":200,"inif":"提示",data:[{*}]}*/

     @GetMapping("queryByTypeIds")
    public  ResponseData queryByTypeIds(Integer typeId){
         if(typeId==null){
             return ResponseData.error(400,"参数不能为空");
         }

         Map list=sporper.queryByTypeIds(typeId);
         return ResponseData.success(list);
     }
}
