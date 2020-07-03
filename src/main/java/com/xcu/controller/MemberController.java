package com.xcu.controller;

import com.xcu.domain.Member;
import com.xcu.service.MemberService;
import com.xcu.vo.FrameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/deleteByPrimaryKey")
    public FrameResponse deleteByPrimaryKey(int id){
        int result = memberService.deleteByPrimaryKey(id);
        if(result==1){
            return FrameResponse.success("删除成功");
        }
        return FrameResponse.failure("删除失败");
    }
    @PostMapping("/insert")
    public FrameResponse insert(Member record){
        int result = memberService.insert(record);
        if(result==1){
            return FrameResponse.success("添加成功");
        }
        return FrameResponse.failure("添加失败");
    }
    @PostMapping("/insertSelective")
    public FrameResponse insertSelective(Member record){
        int result = memberService.insertSelective(record);
        if(result==1){
            return FrameResponse.success("添加成功");
        }
        return FrameResponse.failure("添加失败");
    }
    @GetMapping("/selectByPrimaryKey")
    public FrameResponse selectByPrimaryKey(int id){
        Member Member = memberService.selectByPrimaryKey(id);
        if(Member!=null){
            return FrameResponse.success(Member);
        }
        return FrameResponse.failure("没有该记录");
    }
    @PostMapping("/updateByPrimaryKeySelective")
    public FrameResponse updateByPrimaryKeySelective(Member record){
        int result = memberService.updateByPrimaryKeySelective(record);
        if(result==1){
            return FrameResponse.success("更新成功");
        }
        return FrameResponse.failure("更新失败");
    }

    @PostMapping("/updateByPrimaryKey")
    public FrameResponse updateByPrimaryKey(Member record){
        int result = memberService.updateByPrimaryKey(record);
        if(result==1){
            return FrameResponse.success("更新成功");
        }
        return FrameResponse.failure("更新失败");
    }
}
