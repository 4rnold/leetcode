package com.example.leetcode.ProducerCustomer;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo {

    public static ArrayBlockingQueue q = new ArrayBlockingQueue<Integer>(2);

    LinkedBlockingQueue queue = new LinkedBlockingQueue<Object>();


    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue queue = new LinkedBlockingQueue<Integer>();
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(2000);
                        queue.put(1);
                        System.out.println("put one");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(4000);
                        queue.take();
                        System.out.println("take one" +  queue.size());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        a.start();
        b.start();

        a.join();
        b.join();


    }

}
