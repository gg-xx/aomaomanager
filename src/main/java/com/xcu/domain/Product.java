package com.xcu.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Product {
    private Integer id;

    private String productId;

    private String productName;

    private Integer categoryId;

    private Integer productNumber;

    private Float productPrice;

    private String productDetail;

    private Integer productStatus;
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