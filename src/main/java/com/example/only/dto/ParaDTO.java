package com.example.only.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Author: created by liguoliang
 * Date: 2019/5/9 15:40 40
 * Version: 1.0
 * Function: 用于
 */
@Data
public class ParaDTO {
    private BigDecimal ext1;
    private String ext2;
    private Integer ext3;
    private Long ext4;
    private Float ext5;
    private Date ext6;

    private List<BaseEntity> other001;
    private Map<String,String> other002;

}
