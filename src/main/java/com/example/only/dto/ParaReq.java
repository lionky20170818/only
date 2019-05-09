package com.example.only.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ParaReq implements Serializable {
    private String ext1;
    private String ext2;
    private String ext3;
    private String name;

}
