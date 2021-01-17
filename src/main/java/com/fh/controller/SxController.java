package com.fh.controller;

import com.fh.entity.po.SxValue;
import com.fh.entity.vo.ResponseData;
import com.fh.service.SxSer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/sxvalue")
public class SxController {
    @Resource
    private SxSer sxSer;
    /*
     * 查询属性名字信息
     * 路径： http://localhost:8080/api/sxvalue/querysxvalue
     * 请求方式 get
     * 返回值
     *  code  info   date:{list  count}
     *
     * */
    @GetMapping("querysxvalue")
    public ResponseData querysxvalue(){

        List<SxValue> sxvalue= sxSer.querysxvalue();
        return ResponseData.success(sxvalue);
    }
}
