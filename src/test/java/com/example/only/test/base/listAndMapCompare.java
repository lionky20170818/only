package com.example.only.test.base;

import com.google.common.collect.Maps;
import org.assertj.core.util.Lists;

import java.util.List;
import java.util.Map;

/**
 * Author: created by liguoliang
 * Date: 2019/6/4 16:40 40
 * Version: 1.0
 * Function: 用于
 */
public class listAndMapCompare {
    public static void main(String[] args) {
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
