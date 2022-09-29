package com.example.demo.customdatastructure;

public interface Collection<E> {

    void add(E e);

    boolean contains(Object o);

    boolean remove(Object o);

    int size();
}
