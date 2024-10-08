package org.example;

import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {
    private String name;
    private Container container;

    Producer(String name, Container container) {
        this.name = name;
        this.container = container;
    }

    @Override
    public void run() {
        while (true) {
            int element = createElement();
            synchronized (container) {
                while (container.isFull()) {
                    System.out.println(String.format("Producer[%s] is waiting...\n ", name));
                    try {
                        container.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                container.push(element);
                System.out.println("> Buffer: " + container);
                container.notifyAll();
            }
        }
    }

    private int createElement() {
        int element = make();
//        System.out.println(String.format("Producer[%s] created element: %d ", name, element));
        return element;
    }

    private int make() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Randomizer.generate(0, 10);
    }
}
