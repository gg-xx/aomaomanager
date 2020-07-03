package com.xcu.controller;

import com.github.pagehelper.PageInfo;
import com.xcu.domain.Category;
import com.xcu.service.CategoryService;
import com.xcu.vo.FrameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @DeleteMapping("/delete/{id}")
    public FrameResponse delete(@PathVariable int id){
        int result = categoryService.deleteByPrimaryKey(id);
        if(result==1){
            return FrameResponse.success("删除成功");
        }
        return FrameResponse.failure("删除失败");
    }
    @PostMapping("/add")
    public FrameResponse add(Category record){
        int result = categoryService.insert(record);
        if(result==1){
            return FrameResponse.success("添加成功");
        }
        return FrameResponse.failure("添加失败");
    }
    @PostMapping("/insertSelective")
    public FrameResponse insertSelective(Category record){
        int result = categoryService.insertSelective(record);
        if(result==1){
            return FrameResponse.success("添加成功");
        }
        return FrameResponse.failure("添加失败");
    }
    @GetMapping("/selectByPrimaryKey")
    public FrameResponse selectByPrimaryKey(int id){
        Category category = categoryService.selectByPrimaryKey(id);
        if(category!=null){
            return FrameResponse.success(category);
        }
        return FrameResponse.failure("没有该记录");
    }
    @GetMapping("/search")
    public FrameResponse search(int current, int size,String categoryName){
        PageInfo<Category> pageInfo = categoryService.selectByName(current,size,categoryName);
        if(pageInfo!=null){
            return FrameResponse.success(pageInfo);
        }
        return FrameResponse.failure("没有该记录");
    }

    @PostMapping("/update")
    public FrameResponse update(Category category){
        int result = categoryService.updateByPrimaryKeySelective(category);
        if(result==1){
            return FrameResponse.success("更新成功");
        }
        return FrameResponse.failure("更新失败");
    }

    @PostMapping("/updateByPrimaryKey")
    public FrameResponse updateByPrimaryKey(Category record){
        int result = categoryService.updateByPrimaryKey(record);
        if(result==1){
            return FrameResponse.success("更新成功");
        }
        return FrameResponse.failure("更新失败");
    }
}
