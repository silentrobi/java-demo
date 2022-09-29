package com.example.demo.customdatastructure;

import java.lang.reflect.Array;

public class Set<E> implements Collection<E> {
    private static final int DEFAULT_CAPACITY = 5;
    private Object[] elements = new Array[DEFAULT_CAPACITY];
    private int size = 0;

    public void add(E element) {
        if (contains(element)) {
            return;
        }
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = element;
    }

    @Override
    public boolean contains(Object o) {
        for (int index = 0; index < size; index++) {
            if (elements[index].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int index = 0; index < size; index++) {
            if (elements[index].equals(o)) {
                //As it is an unordered array we copy the last index element to the deleted field
                // and decrement size by 1
                elements[index] = elements[size - 1];
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        int newSize = elements.length * 2;
        System.arraycopy(elements, 0, elements, 0, newSize);
    }
}

