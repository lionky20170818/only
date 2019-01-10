package com.example.only.service.factory;

/**
 * Author: created by liguoliang
 * Date: 2019/1/3 14:09 09
 * Version: 1.0
 * Function: 用于  单例模式
 */
public class SingleObject {
    //饿汉式没有加锁，执行效率快
    //创建 SingleObject 的一个对象
    private static SingleObject instance = new SingleObject();
    //让构造函数为 private，这样该类就不会被实例化
    private SingleObject(){}
    //获取唯一可用的对象
    public static SingleObject getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello Single!");
    }

    // TODO http://www.runoob.com/design-pattern/singleton-pattern.html
    //懒汉式:用的是时候再new
    //饿汉式：一开始就加载
    //双检锁/双重校验锁  还是synchronized
    //登记式/静态内部类

    //工厂模式：用一个工厂类包装几个实现类，只需要传入type值就能获取具体实现类
    //抽象工厂模式：可以多种类实现类型，简单就是多种工厂模式上再加一个abstract抽象 interface
    //单例模式：上面的
    //建造者模式：又称生成器模式；Builder,例如StringBuilder
    //原型模式：直接创建对象的代价较大时使用，实现object类中的clone()方法；或者实现clonenable接口，重写clone方法
    //适配器模式：内存卡和笔记本不能直接交互，需要用读卡器
    //桥接模式Bridge：

}
