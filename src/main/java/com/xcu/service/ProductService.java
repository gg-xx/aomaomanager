package com.xcu.service;

import com.github.pagehelper.PageInfo;
import com.xcu.domain.Product;

public interface ProductService {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    PageInfo<Product> selectByName(int page, int pageSize, String name);
}
