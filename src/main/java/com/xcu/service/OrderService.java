package com.xcu.service;

import com.github.pagehelper.PageInfo;
import com.xcu.domain.Order;

public interface OrderService {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    PageInfo<Order> selectByName(int page, int pageSize, String member);
}
