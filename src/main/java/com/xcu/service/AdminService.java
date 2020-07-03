package com.xcu.service;


import com.github.pagehelper.PageInfo;
import com.xcu.domain.Admin;
import com.xcu.domain.Product;

import java.util.List;

public interface AdminService {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List<Admin> getListById(String ids);

    Admin exists(Admin record);

    PageInfo<Admin> selectByName(int page, int pageSize, String account);
}
