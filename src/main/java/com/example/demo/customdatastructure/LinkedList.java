package com.example.demo.customdatastructure;

public class LinkedList<E> implements Collection<E>, List<E> {

    private Node head = null;
    private int size = 0;

    @Override
    public void add(E e) {
        Node newNode = new Node(e);

        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        Node current = head;
        while (current.next != null) {
            //make newly added Node as head
            current = current.next;
        }

        current.next = newNode;
        size++;
    }

    @Override
    public boolean contains(Object o) {
        Node current = head;
        while (current != null) {
            if (current.element.equals(o)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public boolean remove(Object o) {
        Node current = head;
        if (current == null) {
            return false;
        }
        if (current.element.equals(o)) {
            head = current.next;
            size--;
            return true;
        }

        Node temp = null;
        while (current.next != null) {
            temp = current;
            current = current.next;
            if (current.element.equals(o)) {
                temp.next = current.next;
                size--;
                return true;
            }
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }

        Node current = head;
        for (int i = 1; i <= index; i++) {
            current = current.next;
        }

        return (E) current.element;
    }

    @Override
    public int indexOf(Object o) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.element.equals(o)) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E remove(int index) {
        isValidIndex(index);
        Node current = head;

        if (index == 0) {
            size--;
            head = current.next;
            return (E) current.element;
        }

        Node temp = null;
        for (int i = 1; i <= index; i++) {
            temp = current;
            current = current.next;
        }

        temp.next = current.next;
        size--;

        return (E) current.element;
    }

    @Override
    public E set(int index, E element) {
        isValidIndex(index);
        Node current = head;
        for (int i = 1; i <= index; i++) {
            current = current.next;
        }
        current.element = element;

        return element;
    }

    private void isValidIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
    }

    class Node {

        Object element;
        Node next;

        Node(Object o) {
            this.element = o;
        }
    }
}
