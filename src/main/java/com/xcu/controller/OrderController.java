package com.xcu.controller;

import com.github.pagehelper.PageInfo;
import com.xcu.domain.Order;
import com.xcu.service.OrderService;
import com.xcu.vo.FrameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @DeleteMapping("/delete/{id}")
    public FrameResponse deleteByPrimaryKey(@PathVariable int id){
        int result = orderService.deleteByPrimaryKey(id);
        if(result==1){
            return FrameResponse.success("删除成功");
        }
        return FrameResponse.failure("删除失败");
    }
    @PostMapping("/add")
    public FrameResponse add(Order record){
        int result = orderService.insert(record);
        if(result==1){
            return FrameResponse.success("添加成功");
        }
        return FrameResponse.failure("添加失败");
    }

    @GetMapping("/search")
    public FrameResponse search(int current, int size,String orderMember){
        PageInfo<Order> pageInfo = orderService.selectByName(current,size,orderMember);
        if(pageInfo!=null){
            return FrameResponse.success(pageInfo);
        }
        return FrameResponse.failure("没有该记录");
    }
    @PostMapping("/update")
    public FrameResponse update(Order record){
        int result = orderService.updateByPrimaryKeySelective(record);
        if(result==1){
            return FrameResponse.success("更新成功");
        }
        return FrameResponse.failure("更新失败");
    }

    @PostMapping("/insertSelective")
    public FrameResponse insertSelective(Order record){
        int result = orderService.insertSelective(record);
        if(result==1){
            return FrameResponse.success("添加成功");
        }
        return FrameResponse.failure("添加失败");
    }
    @GetMapping("/selectByPrimaryKey")
    public FrameResponse selectByPrimaryKey(int id){
        Order order = orderService.selectByPrimaryKey(id);
        if(order!=null){
            return FrameResponse.success(order);
        }
        return FrameResponse.failure("没有该记录");
    }

    @PostMapping("/updateByPrimaryKey")
    public FrameResponse updateByPrimaryKey(Order record){
        int result = orderService.updateByPrimaryKey(record);
        if(result==1){
            return FrameResponse.success("更新成功");
        }
        return FrameResponse.failure("更新失败");
    }
}
