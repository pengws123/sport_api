package com.fh.dao;

import com.fh.entity.po.ShoreXian;

import java.util.List;

public interface ShoreDao {
    List<ShoreXian> getshore();

    void saveshore(ShoreXian shore);

    void deleteshore(Integer id);

    ShoreXian queryshoreId(Integer id);

    void updateshore(ShoreXian shore);
}
