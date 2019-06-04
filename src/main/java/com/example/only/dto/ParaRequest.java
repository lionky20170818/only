package com.example.only.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ParaRequest extends ParaDTO implements Serializable {
    private BigDecimal type100;

}
