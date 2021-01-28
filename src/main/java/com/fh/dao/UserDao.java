package com.fh.dao;

import com.fh.entity.po.UserParss;

public interface UserDao {
    UserParss loginuser(String realName);

    void saveuser(UserParss user);
}
