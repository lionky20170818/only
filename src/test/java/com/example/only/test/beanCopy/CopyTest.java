package com.example.only.test.beanCopy;

import cn.hutool.core.bean.BeanUtil;
import com.example.only.dto.BaseEntity;
import com.example.only.dto.ParaReq;
import com.example.only.dto.ParaRequest;
import com.example.only.utils.BeanCopierBeanUtils;
import com.google.common.collect.Maps;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: created by liguoliang
 * Date: 2019/5/9 15:21 21
 * Version: 1.0
 * Function: 用于
 */
public class CopyTest {

    public ParaReq paraReq() {
        ParaReq para = new ParaReq();
        para.setExt1(new BigDecimal("3.1415928"));
        para.setExt2("abf-123");
        para.setExt3(123555);
        para.setExt4(333L);
        para.setExt5(2.998F);

        BaseEntity baseEntity = new BaseEntity();
        baseEntity.setName0("1-1");
        baseEntity.setName1("ppp000");
        List<BaseEntity> list0 = Lists.newArrayList(baseEntity);
        para.setOther001(list0);

        Map paraMap = Maps.newHashMap();
        paraMap.put("ddd","1-2-3");
        para.setOther002(paraMap);


        para.setType100("1234567");
        return  para;
    }

    /**
     * hutool主要功能有缓存、Json工具、加密解密、定时任务等
     * https://blog.csdn.net/jui121314/article/details/83036640
     *
     * 支持字段不同类型copy
     * 程序运行时间： 70242600ns
     */
    @Test
    public  void hutoolCopyTest() {
        ParaReq para = paraReq();
        ParaRequest paraNew = new ParaRequest();
        long startTime=System.nanoTime();
        BeanUtil.copyProperties(para,paraNew);
        long endTime=System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
    }

    @Test
    public  void hutoolCopyMapTest() {
        Map para = Maps.newHashMap();
        para.put("ext1","111");
        para.put("ext2","111");
        ParaRequest paraNew = new ParaRequest();
        long startTime=System.nanoTime();
        BeanUtil.copyProperties(para,paraNew);
        long endTime=System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
    }

    /**
     * 不支持字段不同类型copy
     * 程序运行时间： 329608200ns
     */
    @Test
    public  void springCopyTest() {
        ParaReq para = paraReq();
        ParaRequest paraNew = new ParaRequest();
        long startTime=System.nanoTime();
        BeanUtils.copyProperties(para,paraNew);
        long endTime=System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
    }

    /**
     * 不支持字段不同类型copy
     * 程序运行时间： 217540900ns
     */
    @Test
    public  void beanCopierCopyTest() {
        //cglib
        ParaReq para = paraReq();
        ParaRequest paraNew = new ParaRequest();
        long startTime=System.nanoTime();
        BeanCopierBeanUtils.copy(para,paraNew);
        long endTime=System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
    }


    @Test
    public void asssss(){
        String groupFlag="RICHEMONT1";
        Boolean isRed = false;
//        Boolean aaa = "RICHEMONT".equals(groupFlag)&&isRed;
        if(!("RICHEMONT".equals(groupFlag)&&isRed)){
            System.out.println("11==");
        }else {
            System.out.println("222==");
        }
    }

}
