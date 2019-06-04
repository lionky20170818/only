package com.example.only.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class ParaReq extends ParaDTO implements Serializable {
    private String type100;

}
