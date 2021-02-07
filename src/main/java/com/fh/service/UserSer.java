package com.fh.service;

import com.fh.entity.po.Juese;
import com.fh.entity.po.UserParss;
import com.fh.entity.vo.Paramss;

import java.util.List;
import java.util.Map;

public interface UserSer {
    Map loginuser(UserParss user);


    Map saveuser(UserParss user);

    Map queryuser(Paramss param);

    void deleteuser(Integer id);

    UserParss selectuser(Integer id);

    void updateuser(UserParss user);

    List<Juese> queryuserjue(Integer uid);
}
