package m2s9_dsa_list.review.linkedlist_class_method;

import m2s9_dsa_list.review.arraylist_class_method.MyList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
        System.out.println("-----add first & last-----");
        myLinkedList.addFirst(0);
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addFirst(-1);
        myLinkedList.addFirst(-2);
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.print(myLinkedList.get(i) + "\t");
        }
        System.out.println();
        System.out.println("-----add by index-----");
        myLinkedList.add(2, 5);
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.print(myLinkedList.get(i) + "\t");
        }
        System.out.println();
        System.out.println("-----remove-----");
        myLinkedList.remove(2);
        System.out.println(myLinkedList.remove(new Integer(-1)));
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.print(myLinkedList.get(i) + "\t");
        }
        System.out.println();
        System.out.println("-----size-----");
        System.out.println(myLinkedList.size());
        System.out.println("-----contain-----");
        System.out.println("is contained -2: " + myLinkedList.contains(-2));
        System.out.println("is contained 5: " + myLinkedList.contains(5));
        System.out.println("-----index of-----");
        System.out.println("index of 1: " + myLinkedList.indexOf(1));
        System.out.println("index of 10: " + myLinkedList.indexOf(10));
        System.out.println("-----get first & last-----");
        System.out.println("get first: " + myLinkedList.getFirst());
        System.out.println("get last: " + myLinkedList.getLast());
        System.out.println("-----clone-----");
        MyLinkedList<Integer> newList = myLinkedList.clone();
        System.out.println("new list: ");
        for (int i = 0; i < newList.size(); i++) {
            System.out.print(newList.get(i) + "\t");
        }
        System.out.println();
        System.out.println("----clear----");
        System.out.println("new list before clear: ");
        for (int i = 0; i < newList.size(); i++) {
            System.out.print(newList.get(i) + "\t");
        }
        System.out.println();
        newList.clear();
        System.out.println("new list after clear: ");
        for (int i = 0; i < newList.size(); i++) {
            System.out.print(newList.get(i) + "\t");
        }
        System.out.println();
    }
}
