package com.example.only.tools.duoxiancheng;

import java.math.BigDecimal;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Author: created by liguoliang
 * Date: 2018/12/4 13:51 51
 * Version: 1.0
 * Function: 用于
 * 假若有若干个线程都要进行写数据操作，并且只有所有线程都完成写数据操作之后，
 * 这些线程才能继续做后面的事情，此时就可以利用CyclicBarrier了：
 */
public class CyclicBarrierTest {

//    public static void main(String[] args) {
//        int N = 4;
//        CyclicBarrier barrier  = new CyclicBarrier(N);
//        for(int i=0;i<N;i++)
//            new Writer(barrier).start();
//    }
    static class Writer extends Thread{
        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
            try {
                Thread.sleep(5000);      //以睡眠来模拟写入数据操作
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch(BrokenBarrierException e){
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }


    public static void main(String[] args) {
        BigDecimal amount = new BigDecimal("306.825000");
        BigDecimal qu = new BigDecimal("48.850000");
        BigDecimal price = new BigDecimal("6.280962128966223");
        BigDecimal qu2 = amount.divide(qu, 20, BigDecimal.ROUND_HALF_UP);
        BigDecimal qu3 = price.multiply(qu);

        System.out.println("==="+qu2);

    }


}
