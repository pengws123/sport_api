package com.fh.service;

import com.fh.entity.po.UserParss;
import com.fh.entity.vo.Paramss;

import java.util.Map;

public interface UserSer {
    Map loginuser(UserParss user);


    Map saveuser(UserParss user);

    Map queryuser(Paramss param);

    void deleteuser(Integer id);
}
