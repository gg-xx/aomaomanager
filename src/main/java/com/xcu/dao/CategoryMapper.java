package com.xcu.dao;

import com.xcu.domain.Category;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    List<Category> selectByName(String name);

    int updateByPrimaryKeySelective(Category record);

    int updateByName(String categoryName);

    int updateByPrimaryKey(Category record);
}