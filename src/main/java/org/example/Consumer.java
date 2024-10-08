package org.example;

import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    private String name;
    private Container container;

    Consumer(String name, Container container) {
        this.name = name;
        this.container = container;
    }

    @Override
    public void run() {
        while (true) {
            Integer element;
            synchronized (container) {
                while (container.isEmpty()) {
                    System.out.println(String.format("Consumer[%s] is waiting...\n ", name));
                    try {
                        container.wait();
                     } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                element = container.pull();
                System.out.println("# Buffer: " + container);
                container.notifyAll();
            }
            handle(element);
        }
    }

    private void handle(Integer element) {
//        System.out.println(String.format("Consumer[%s] handled element: %d\n", name, element));
        try {
            TimeUnit.MILLISECONDS.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
