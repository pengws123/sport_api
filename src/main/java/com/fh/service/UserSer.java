package com.fh.service;

import com.fh.entity.po.UserParss;

import java.util.Map;

public interface UserSer {
    Map loginuser(UserParss user);


    Map saveuser(UserParss user);
}
