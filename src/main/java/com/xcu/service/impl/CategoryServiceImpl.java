package com.xcu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xcu.dao.CategoryMapper;
import com.xcu.domain.Category;
import com.xcu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Category record) {
        record.setCreateTime(new Date());
        return categoryMapper.insert(record);
    }

    @Override
    public int insertSelective(Category record) {
        record.setCreateTime(new Date());
        return categoryMapper.insertSelective(record);
    }

    @Override
    public Category selectByPrimaryKey(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Category record) {
        record.setOperateTime(new Date());
        return categoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Category record) {
        record.setOperateTime(new Date());
        return categoryMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Category> selectByName(int page, int pageSize,String name) {
        PageHelper.startPage(page,pageSize);
        List<Category> categories = categoryMapper.selectByName(name);
        PageInfo<Category> pageInfo=new PageInfo<>(categories);
        return pageInfo;
    }
}
