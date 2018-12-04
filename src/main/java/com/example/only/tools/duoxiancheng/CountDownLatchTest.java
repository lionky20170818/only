package com.example.only.tools.duoxiancheng;

import java.util.concurrent.CountDownLatch;

/**
 * Author: created by liguoliang
 * Date: 2018/12/4 9:57 57
 * Version: 1.0
 * Function: 用于利用它可以实现类似计数器的功能。
 * 比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了。
 */
//http://www.importnew.com/21889.html

public class CountDownLatchTest {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(3);
        for(int i=0;i<3;i++){
            new Thread(){
                public void run() {
                    try {
                        System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                        Thread.sleep(3000);
                        System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                        latch.countDown();//将count值减1
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                };
            }.start();
        }
        try {
            System.out.println("等待3个子线程执行完毕...");
            latch.await();
            System.out.println("3个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
