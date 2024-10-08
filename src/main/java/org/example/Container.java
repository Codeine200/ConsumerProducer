package org.example;

import java.util.StringJoiner;

public class Container implements Buffer, Queue<Integer> {

    private int[] arr;
    private int size;
    private final int maxElement;

    Container(int maxElement) {
        this.maxElement = maxElement;
        arr = new int[maxElement];
    }

    @Override
    public boolean isFull() {
        return size == maxElement;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean push(Integer element) {
        if (!isFull()) {
            arr[size++] = element;
            return true;
        }
        return false;
    }

    @Override
    public Integer pull() {
        int element = arr[0];
        size--;
        System.arraycopy(arr, 1, arr, 0, maxElement - 1);
        return element;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        StringJoiner joiner = new StringJoiner(", ");
        for(int i=0; i<size; i++) {
            joiner.add(String.valueOf(arr[i]));
        }
        builder.append(joiner);
        builder.append("]");
        return builder.toString();
    }
}
