package com.fh.dao;

import com.fh.entity.po.SporPeoper;
import com.fh.entity.po.UserParss;
import com.fh.entity.vo.Paramss;

import java.util.List;

public interface UserDao {
    UserParss loginuser(String realName);

    void saveuser(UserParss user);

    Integer querycount(Paramss param);

    List<UserParss> queryuser(Paramss param);

    void deleteuser(Integer id);
}
