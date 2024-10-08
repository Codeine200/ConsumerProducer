package org.example;

public class Main {
    public static void main(String[] args) {
        Container buff = new Container(25);
        Thread producer1 = new Thread(new Producer("#1", buff));
        Thread producer2 = new Thread(new Producer("#2", buff));
        Thread producer3 = new Thread(new Producer("#3", buff));
        Thread consumer1 = new Thread(new Consumer("#1", buff));
        Thread consumer2 = new Thread(new Consumer("#2", buff));
        producer1.start();
        producer2.start();
  //      producer3.start();
        consumer1.start();
  //      consumer2.start();
    }
}