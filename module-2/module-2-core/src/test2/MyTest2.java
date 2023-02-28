package test2;

import test.MyAbstractClass;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyTest2 extends MyAbstractClass {

    @Override
    protected String abc() {
        return null;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new LinkedList<>();
        System.out.println(numbers.add(2));
    }
}
