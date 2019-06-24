package com.example.only.test.base;

import com.example.only.dto.BaseEntity;
import com.google.common.collect.Maps;
import org.assertj.core.util.Lists;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Author: created by liguoliang
 * Date: 2019/6/4 16:40 40
 * Version: 1.0
 * Function: 用于
 */
public class listAndMapCompare {
    public static void main(String[] args) {

        List<BaseEntity> personList = new ArrayList<>();
        BaseEntity a = new BaseEntity();
        a.setName0("111");
        a.setName1("");
        personList.add(a);
        BaseEntity c = new BaseEntity();
        c.setName0("111");
        c.setName1(null);
        personList.add(c);
        BaseEntity b = new BaseEntity();
        b.setName0("");
        b.setName1("");
        personList.add(b);
        BaseEntity d = new BaseEntity();
        d.setName0(null);
        d.setName1("sss");
        personList.add(d);
        Set<String> orderNoSet = new HashSet<>();
        for(int i=0;i<personList.size();i++){
            BaseEntity para = personList.get(i);
            orderNoSet.add(para.getName0());
        }

        int counta = orderNoSet.size();
//        Collections.sort(personList); 需重写compare
//        ####   null值的话会报空指针异常，如果要存null，需重写compareTo方法
//        List<BaseEntity> distinctList = personList.stream()
//                .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(BaseEntity::getName0))), ArrayList::new));

        List<Integer> array = Lists.newArrayList();
        Map<Integer,Integer> hash = Maps.newHashMap();
        for(int i=1;i<9999999;i++){
            array.add(i);
            hash.put(i,i);
        }
        long a1=System.nanoTime();
        System.out.println("="+array.contains(5000));
        long a2=System.nanoTime();
        System.out.println("1=="+(a2-a1));

        long a11=System.nanoTime();
        System.out.println("="+hash.containsKey(5000));
        long a12=System.nanoTime();
        System.out.println("2=="+(a12-a11));

        long a21=System.nanoTime();
        System.out.println("="+hash.keySet().contains(5000));
        long a22=System.nanoTime();
        System.out.println("3=="+(a22-a21));

    }
}
