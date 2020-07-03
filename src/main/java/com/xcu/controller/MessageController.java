package com.xcu.controller;

import com.xcu.domain.Message;
import com.xcu.service.MessageService;
import com.xcu.vo.FrameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/deleteByPrimaryKey")
    public FrameResponse deleteByPrimaryKey(int id){
        int result = messageService.deleteByPrimaryKey(id);
        if(result==1){
            return FrameResponse.success("删除成功");
        }
        return FrameResponse.failure("删除失败");
    }
    @PostMapping("/insert")
    public FrameResponse insert(Message record){
        int result = messageService.insert(record);
        if(result==1){
            return FrameResponse.success("添加成功");
        }
        return FrameResponse.failure("添加失败");
    }
    @PostMapping("/insertSelective")
    public FrameResponse insertSelective(Message record){
        int result = messageService.insertSelective(record);
        if(result==1){
            return FrameResponse.success("添加成功");
        }
        return FrameResponse.failure("添加失败");
    }
    @GetMapping("/selectByPrimaryKey")
    public FrameResponse selectByPrimaryKey(int id){
        Message Message = messageService.selectByPrimaryKey(id);
        if(Message!=null){
            return FrameResponse.success(Message);
        }
        return FrameResponse.failure("没有该记录");
    }
    @PostMapping("/updateByPrimaryKeySelective")
    public FrameResponse updateByPrimaryKeySelective(Message record){
        int result = messageService.updateByPrimaryKeySelective(record);
        if(result==1){
            return FrameResponse.success("更新成功");
        }
        return FrameResponse.failure("更新失败");
    }

    @PostMapping("/updateByPrimaryKey")
    public FrameResponse updateByPrimaryKey(Message record){
        int result = messageService.updateByPrimaryKey(record);
        if(result==1){
            return FrameResponse.success("更新成功");
        }
        return FrameResponse.failure("更新失败");
    }
}
