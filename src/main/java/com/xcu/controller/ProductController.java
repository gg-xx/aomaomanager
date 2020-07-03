package com.xcu.controller;

import com.github.pagehelper.PageInfo;
import com.xcu.domain.Product;
import com.xcu.service.ProductService;
import com.xcu.vo.FrameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @DeleteMapping("/delete/{id}")
    public FrameResponse deleteByPrimaryKey(@PathVariable int id){
        int result = productService.deleteByPrimaryKey(id);
        if(result==1){
            return FrameResponse.success("删除成功");
        }
        return FrameResponse.failure("删除失败");
    }
    @PostMapping("/add")
    public FrameResponse add(Product record){
        int result = productService.insert(record);
        if(result==1){
            return FrameResponse.success("添加成功");
        }
        return FrameResponse.failure("添加失败");
    }
    @GetMapping("/search")
    public FrameResponse search(int current, int size,String productName){
        PageInfo<Product> pageInfo = productService.selectByName(current,size,productName);
        if(pageInfo!=null){
            return FrameResponse.success(pageInfo);
        }
        return FrameResponse.failure("没有该记录");
    }
    @PostMapping("/update")
    public FrameResponse update(Product record){
        int result = productService.updateByPrimaryKeySelective(record);
        if(result==1){
            return FrameResponse.success("更新成功");
        }
        return FrameResponse.failure("更新失败");
    }
    @PostMapping("/insertSelective")
    public FrameResponse insertSelective(Product record){
        int result = productService.insertSelective(record);
        if(result==1){
            return FrameResponse.success("添加成功");
        }
        return FrameResponse.failure("添加失败");
    }
    @GetMapping("/selectByPrimaryKey")
    public FrameResponse selectByPrimaryKey(int id){
        Product product = productService.selectByPrimaryKey(id);
        if(product!=null){
            return FrameResponse.success(product);
        }
        return FrameResponse.failure("没有该记录");
    }

    @PostMapping("/updateByPrimaryKey")
    public FrameResponse updateByPrimaryKey(Product record){
        int result = productService.updateByPrimaryKey(record);
        if(result==1){
            return FrameResponse.success("更新成功");
        }
        return FrameResponse.failure("更新失败");
    }
}
