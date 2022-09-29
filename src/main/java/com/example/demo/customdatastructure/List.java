package com.example.demo.customdatastructure;

public interface List<E> {
    E get(int index);

    int indexOf(Object o);

    void clear();

    boolean isEmpty();

    E remove(int index);

    E set(int index, E element);
}
