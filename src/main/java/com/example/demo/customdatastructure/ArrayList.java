package com.example.demo.customdatastructure;

public class ArrayList<E> implements Collection<E>, List<E> {
    //Size of list
    private int size = 0;

    //Default capacity of list is 10
    private static final int DEFAULT_CAPACITY = 10;

    //This array will store all elements added to list
    private Object elements[];

    //Default constructor
    public ArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    //Add method
    @Override
    public void add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
    }

    @Override
    public boolean contains(Object o) {
        for (Object element : elements) {
            if (o.equals(element)) {
                return true;
            }
        }

        return false;
    }

    //Get method
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return (E) elements[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int index = 0; index < elements.length; index++) {
            if (elements[index].equals(o)) {
                return index;
            }
        }

        return -1;
    }

    @Override
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(Object o) {
        for (int index = 0; index < elements.length; index++) {
            if (elements[index].equals(o)) {
                final Object item = elements[index];
                // Shift all elements from (i+1) position to one position left.
                System.arraycopy(elements, index + 1, elements, index, elements.length - (index + 1));
                size--;
                return true;
            }
        }

        return false;
    }

    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        Object item = elements[index];
        // Shift all elements from (i+1) position to one position left.
        System.arraycopy(elements, index + 1, elements, index, elements.length - (index + 1));
        size--;
        return (E) item;
    }

    @Override
    public E set(int index, E element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        elements[index] = element;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    private void ensureCapacity() {
        int newSize = elements.length * 2;
        System.arraycopy(elements, 0, elements, 0, newSize);
    }
}