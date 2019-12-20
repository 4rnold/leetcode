package com.example.leetcode.ProducerCustomer.testError;

import java.util.List;
import java.util.UUID;

public class Producer implements Runnable{
    private final List<String> boxes;
    
    public Producer(List<String> aboxes) {
        super();
        this.boxes = aboxes;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (boxes) {
                try {
                    int size = this.boxes.size();
                    // int size = this.boxes.size();

                    // 以下两行均可正确运行
                    // while(5 == this.boxes.size()) {
                     while(5 == boxes.size()) {
                    // 程序出现问题
//                    while (5 == size) {
                        System.out.println(Thread.currentThread().getName() + 
                                " : 容量已满, 等待.....");
                        boxes.wait();
                    }
                    Thread.sleep(500);
                    String product = "产品 :  " + UUID.randomUUID().toString();
                    boxes.add(product);
                    System.out.println(Thread.currentThread().getName() + 
                            " : 生产了 :  " + product + " 总量 : " + boxes.size());
                    
                    boxes.notifyAll();
                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }  
        }
    }
}