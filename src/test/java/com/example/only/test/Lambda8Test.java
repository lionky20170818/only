package com.example.only.test;

import com.example.only.OnlyApplicationTests;
import com.example.only.dto.ParaReq;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: created by liguoliang
 * Date: 2019/5/9 11:12 12
 * Version: 1.0
 * Function: 用于
 */
public class Lambda8Test extends OnlyApplicationTests {

    @Test
    public  void normalTest() {
        List strs = Lists.newArrayList("1","2","a","3");
        //快
        strs.parallelStream().forEach(str -> {
            System.out.println("str1="+str);
        });

        //没使用扁平化
        strs.parallelStream().forEachOrdered(str -> {
            System.out.println("str0="+str);
        });

        //一般性能
        strs.stream().forEach(str -> {
            System.out.println("str2="+str);
        });

        //stream.map
        List<String> newStrs = (List<String>) strs.stream().map(str -> {
                    return str + "ddd";
                }
        ).collect(Collectors.toList());

        System.out.println("str3="+newStrs.get(0));

        ParaReq req = new ParaReq();
        req.setExt2("asd123");
        List<ParaReq> paraLists = Lists.newArrayList(req);
        List<String> newLists = paraLists.stream().map(para->{
            return para.getExt1()+"qqq";
        }).collect(Collectors.toList());
        List<String> newLists0 = paraLists.stream().map(para->para.getExt2()
        ).collect(Collectors.toList());
        List<String> newLists1 = paraLists.stream().map(ParaReq::getExt2
        ).collect(Collectors.toList());

        System.out.println("str4="+newLists.get(0));
        System.out.println("str5="+newLists0.get(0));
        System.out.println("str6="+newLists1.get(0));


    }
}
