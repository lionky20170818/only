package com.example.only.test;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: created by liguoliang
 * Date: 2018/10/23 15:53 53
 * Version: 1.0
 * Function: 用于
 */
public class VolatileTest {
    //java内存模型中：
    //可见性
    //有序性
    //原子性
    //volatile只保证了可见性和有序性
    private AtomicInteger number = new AtomicInteger(0);
    private volatile int count = 0;
    ExecutorService executor = Executors.newFixedThreadPool(10);
    @Test
    public void volatileTest() {
        final VolatileTest v = new VolatileTest();
        for (int i = 0; i < 10000; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    increase();
                }
            }).start();
        }

        final CountDownLatch cd = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++){
            executor.execute(new Runnable() {
                public void run() {
                    number.incrementAndGet();
//                    System.out.printf("线程 %s \n", Thread.currentThread().getId());
                    cd.countDown();
                }
            });
        }


        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count+"="+count);
        System.out.println(number+"="+number);

    }

    public synchronized void increase() {
        count++;
    }


    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getId()+"=");
    }

}
