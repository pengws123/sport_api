package com.fh.controller;

import com.fh.entity.po.ShangPin;
import com.fh.entity.vo.ResponseData;
import com.fh.service.ShangPinSer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("api/pin")
public class ShangPinController {

    @Resource
    private ShangPinSer shangPinSer;

    /*
     * 新增商品信息
     * 路径： http://localhost:8080/api/pin/savesshangpin
     * 请求方式 post
     *
     * 参数
     *  SporPeoper   对象
     *
     *  返回值  code  info
     * */

    @PostMapping("savesshangpin")

    public ResponseData savesshangpin(ShangPin shan){
        if(shan==null){
            return ResponseData.error(400,"起始小标不能为空");
        }
        shan.setIsDel(0);
        shan.setCreateDate(new Date());
        shangPinSer.savesshangpin(shan);
        return ResponseData.success(null);
    }

    /*
     * 删除商品信息
     * 路径： http://localhost:8080/api/pin/delshangpin
     * 请求方式 post
     *
     * 参数   id
     *  SporPeoper   对象
     *
     *  返回值  code  info
     * */

    @PostMapping("delshangpin")
    public ResponseData delshangpin(Integer id){
        if(id==null){
            return ResponseData.error(400,"起始小标不能为空");
        }
        shangPinSer.delshangpin(id);
        return ResponseData.success(null);
    }

    /*
     * 根据Id 查询商品信息
     * 路径： http://localhost:8080/api/pin/selectshangpin
     * 请求方式 post
     *
     * 参数   id
     *  SporPeoper   对象
     *
     *  返回值  code  info data:{}
     * */
    @PostMapping("selectshangpin")
    public  ResponseData selectshangpin(Integer id){
        if(id==null){
            return ResponseData.error(400,"起始小标不能为空");
        }
       ShangPin sang= shangPinSer.selectshangpin(id);
        return ResponseData.success(sang);
    }
    /*
     * 修改商品信息
     * 路径： http://localhost:8080/api/pin/updateshangpin
     * 请求方式 post
     *
     *
     *  SporPeoper   对象
     *
     *  返回值  code  info
     * */
    @PostMapping("updateshangpin")
    public  ResponseData updateshangpin(ShangPin shan){
        if(shan==null){
            return ResponseData.error(400,"起始小标不能为空");
        }
        shan.setUpdateDate(new Date());
        shangPinSer.updateshangpin(shan);
        return ResponseData.success(null);
    }
}
