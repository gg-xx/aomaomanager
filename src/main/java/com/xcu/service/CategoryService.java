package com.xcu.service;

import com.github.pagehelper.PageInfo;
import com.xcu.domain.Category;

public interface CategoryService {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    PageInfo<Category> selectByName(int page, int pageSize,String name);
}
