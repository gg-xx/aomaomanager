package com.xcu.dao;

import com.xcu.domain.Admin;
import com.xcu.domain.Order;

import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List<Admin> getListById(String ids);

    Admin exists(Admin record);

    List<Admin> selectByName(String account);
}