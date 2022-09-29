package com.example.demo.customdatastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    void add() {

        LinkedList<String> list = new LinkedList<>();

        list.add("a");
        list.add("b");

        Assertions.assertEquals(2, list.size());
    }

    @Test
    void contains() {
        LinkedList<String> list = new LinkedList<>();

        list.add("a");
        list.add("b");

        boolean trueResult = list.contains("b");
        boolean falseResult = list.contains("c");

        Assertions.assertTrue(trueResult);
        Assertions.assertFalse(falseResult);
    }

    @Test
    void removeFromEmptyElement() {
        LinkedList<String> list = new LinkedList<>();

        boolean removed = list.remove("a");

        Assertions.assertFalse(removed);
    }

    @Test
    void removeFirstElement() {
        LinkedList<String> list = new LinkedList<>();

        list.add("a");
        list.add("b");

        boolean removed = list.remove("a");

        Assertions.assertTrue(removed);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void removeMiddleElement() {
        LinkedList<String> list = new LinkedList<>();

        list.add("a");
        list.add("b");
        list.add("c");

        boolean removed = list.remove("b");

        Assertions.assertTrue(removed);
        Assertions.assertEquals(2, list.size());
    }

    @Test
    void removeLastElement() {
        LinkedList<String> list = new LinkedList<>();

        list.add("a");
        list.add("b");
        list.add("c");

        boolean removed = list.remove("c");

        Assertions.assertTrue(removed);
        Assertions.assertEquals(2, list.size());
    }

    @Test
    void get() {
        LinkedList<String> list = new LinkedList<>();

        list.add("a");
        list.add("b");
        list.add("c");

        String element1 = list.get(1);
        String element2 = list.get(2);

        Assertions.assertEquals("b",element1);
        Assertions.assertEquals("c",element2);
    }

    @Test
    void indexOf() {
        LinkedList<String> list = new LinkedList<>();

        list.add("a");
        list.add("b");
        list.add("c");

        int element1Index = list.indexOf("a");
        int element2Index = list.indexOf("b");
        int element3Index = list.indexOf("c");

        Assertions.assertEquals(0,element1Index);
        Assertions.assertEquals(1,element2Index);
        Assertions.assertEquals(2,element3Index);
    }

    @Test
    void removeByIndex() {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        String element = list.remove(0);
        Assertions.assertEquals("a",element);
        Assertions.assertEquals(0,list.size());

        list = new LinkedList<>();
        list.add("a");
        list.add("b");
        element = list.remove(1);
        Assertions.assertEquals("b",element);
        Assertions.assertEquals("a",list.get(0));
        Assertions.assertEquals(1,list.size());

        list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        element = list.remove(1);
        Assertions.assertEquals("b",element);
        Assertions.assertEquals("a",list.get(0));
        Assertions.assertEquals("c",list.get(1));
        Assertions.assertEquals(2,list.size());
    }

    @Test
    void set(){
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        String element = list.set(0, "b");
        Assertions.assertEquals("b",element);
        Assertions.assertEquals("b",list.get(0));
    }
}
