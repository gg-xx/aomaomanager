package com.xcu.controller;

import com.github.pagehelper.PageInfo;
import com.xcu.domain.Admin;
import com.xcu.domain.Product;
import com.xcu.service.AdminService;
import com.xcu.vo.FrameResponse;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @DeleteMapping("/delete/{id}")
    public FrameResponse deleteByPrimaryKey(@PathVariable int id){
        int flag=adminService.deleteByPrimaryKey(id);
        if(flag==1){
            return FrameResponse.success("true");
        }
        return FrameResponse.failure("false");
    }

    @PostMapping("/add")
    public FrameResponse add(Admin admin){
        int result = adminService.insert(admin);
        if(result==1){
            return FrameResponse.success("添加成功");
        }
        return FrameResponse.failure("添加失败");
    }
    @GetMapping("/search")
    public FrameResponse search(int current, int size,String adminAccount){
        PageInfo<Admin> pageInfo = adminService.selectByName(current,size,adminAccount);
        if(pageInfo!=null){
            return FrameResponse.success(pageInfo);
        }
        return FrameResponse.failure("没有该记录");
    }

    @PostMapping("/update")
    public FrameResponse update(Admin admin){
        int result = adminService.updateByPrimaryKeySelective(admin);
        if(result==1){
            return FrameResponse.success("更新成功");
        }
        return FrameResponse.failure("更新失败");
    }
    @PostMapping("/insertSelective")
    public FrameResponse insertSelective(Admin admin){
        int result = adminService.insertSelective(admin);
        if(result==1){
            return FrameResponse.success("添加成功");
        }
        return FrameResponse.failure("添加失败");
    }
    @GetMapping("/selectByPrimaryKey")
    public FrameResponse selectByPrimaryKey(int id){
        Admin admin = adminService.selectByPrimaryKey(id);
        return FrameResponse.success(admin);
    }


    @PostMapping("/exists")
    public FrameResponse exists(Admin admin){
        Admin exists = adminService.exists(admin);
        if(exists!=null){
            return FrameResponse.success("登录成功");
        }
        return FrameResponse.failure("登录失败");
    }

    @PostMapping("/updateByPrimaryKey")
    public FrameResponse updateByPrimaryKey(Admin admin){
        int result = adminService.updateByPrimaryKey(admin);
        if(result==1){
            return FrameResponse.success("更新成功");
        }
        return FrameResponse.failure("更新失败");
    }
    @GetMapping("/getListById")
    public FrameResponse getListById(String ids){
        List<Admin> listById = adminService.getListById(ids);
        return FrameResponse.success(listById);
    }
}
