package com.xcu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xcu.dao.AdminMapper;
import com.xcu.domain.Admin;
import com.xcu.domain.Product;
import com.xcu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Admin record) {
        return adminMapper.insert(record);
    }

    @Override
    public int insertSelective(Admin record) {
        return adminMapper.insertSelective(record);
    }

    @Override
    public Admin selectByPrimaryKey(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Admin record) {
        return adminMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return adminMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Admin> getListById(String ids) {
        return adminMapper.getListById(ids);
    }

    @Override
    public Admin exists(Admin record) {
        return adminMapper.exists(record);
    }

    @Override
    public PageInfo<Admin> selectByName(int page, int pageSize, String account) {
        PageHelper.startPage(page,pageSize);
        List<Admin> admins = adminMapper.selectByName(account);
        PageInfo<Admin> pageInfo=new PageInfo<>(admins);
        return pageInfo;
    }
}
