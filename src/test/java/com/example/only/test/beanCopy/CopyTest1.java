package com.example.only.test.beanCopy;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import com.example.only.dto.BaseEntity;
import com.example.only.dto.ParaReq;
import com.example.only.dto.ParaRequest;
import com.google.common.collect.Maps;
import org.assertj.core.util.Lists;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Author: created by liguoliang
 * Date: 2019/5/9 15:21 21
 * Version: 1.0
 * Function: 用于
 */
public class CopyTest1 {

    public ParaReq paraReq() {
        ParaReq para = new ParaReq();
        para.setExt1(new BigDecimal("3.1415928"));
        para.setExt2("abf-123");
        para.setExt3(123555);
        para.setExt4(333L);
        para.setExt5(2.998F);
        para.setExt6(new Date());

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
     * 支持字段不同类型copy
     * 程序运行时间： 264306900ns
     */
    @Test
    public  void apacheCopyTest1() throws InvocationTargetException, IllegalAccessException {
        ParaReq para = paraReq();
        ParaRequest paraNew = new ParaRequest();
        long startTime=System.nanoTime();
        BeanUtils.copyProperties(paraNew,para);
        long endTime=System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
    }

    /**
     * 不支持字段不同类型copy且报错
     */
    @Test
    public  void apacheCopyTest2() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        ParaReq para = paraReq();
        ParaRequest paraNew = new ParaRequest();
        long startTime=System.nanoTime();
        PropertyUtils.copyProperties(paraNew,para);
        long endTime=System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
    }

    /**
     * 支持字段不同类型copy且报错
     * 程序运行时间： 543750200ns
     */
    @Test
    public  void dozerCopyTest2() {
        ParaReq para = paraReq();
        long startTime=System.nanoTime();

        Mapper mapper = new DozerBeanMapper();
//        ParaRequest paraNew = mapper.map(para, ParaRequest.class);
        // or
        ParaRequest destObject = new ParaRequest();
        mapper.map(para, destObject);
        long endTime=System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
    }


}
