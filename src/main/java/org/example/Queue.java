package org.example;

public interface Queue<T> {
    boolean push(T element);
    T pull();
}
