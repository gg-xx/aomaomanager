package com.xcu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xcu.dao.CategoryMapper;
import com.xcu.dao.OrderMapper;
import com.xcu.domain.Order;
import com.xcu.domain.Product;
import com.xcu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Order record) {
        record.setOrderTime(new Date());
        return orderMapper.insert(record);
    }

    @Override
    public int insertSelective(Order record) {
        return orderMapper.insertSelective(record);
    }

    @Override
    public Order selectByPrimaryKey(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Order record) {
        record.setOperateTime(new Date());
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Order> selectByName(int page, int pageSize, String member) {
        PageHelper.startPage(page,pageSize);
        List<Order> products = orderMapper.selectByName(member);
        PageInfo<Order> pageInfo=new PageInfo<>(products);
        return pageInfo;
    }
}
