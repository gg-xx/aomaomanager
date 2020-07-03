package com.xcu.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Member {
    private Integer id;

    private String memberName;

    private String memberAlias;

    private String memberLoginName;

    private String memberPassword;

    private String memberSex;

    private String memberTel;

    private String memberAddress;

    private String memberEmail;

    private Date memberRegisterTime;

    private Byte memberStatus;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String creator;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date operateTime;

    private String operator;

    private Boolean deleteFlag;

}