package com.example.only.service.factory;

/**
 * Author: created by liguoliang
 * Date: 2019/1/3 14:33 33
 * Version: 1.0
 * Function: 用于
 */
public class SingleTest {
    public static void main(String[] args) {
//        SingleObject single = new SingleObject();//编译时错误：构造函数 SingleObject() 是不可见的

        SingleObject single = SingleObject.getInstance();
        single.showMessage();

    }
}
