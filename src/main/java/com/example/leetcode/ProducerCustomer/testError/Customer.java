package com.example.leetcode.ProducerCustomer.testError;

import java.util.ArrayList;
import java.util.List;

public class Customer implements Runnable{
    private final List<String> boxes;
    
    public Customer(List<String> aboxes) {
        super();
        this.boxes = aboxes;
        
    }
    @Override
    public void run() {
        while (true) {
            synchronized (boxes) {
                try {
                    while (boxes.isEmpty()) {
                        System.out.println(Thread.currentThread().getName() +
                                " : 容量已空, 等待......");
                        boxes.wait(); 
                        
                    }
                    Thread.sleep(1000); 
                    String product = boxes.remove(0);
                    System.out.println(Thread.currentThread().getName() +
                            " : 消费了 :  " + product + " 剩余总量 : " + this.boxes.size());
                      
                    boxes.notifyAll();
                   
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }  
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> boxes = new ArrayList<String>();
        Thread customer = new Thread(new Customer(boxes), "customer");
        Thread producer = new Thread(new Producer(boxes), "producer");

        producer.start();
        customer.start();
    }
}