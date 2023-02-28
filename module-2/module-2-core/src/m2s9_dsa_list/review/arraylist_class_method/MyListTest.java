package m2s9_dsa_list.review.arraylist_class_method;

import java.util.Arrays;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<Integer>();
        System.out.println("-----add-----");
        myList.add(0);
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + "\t");
        }
        System.out.println();
        System.out.println("-----add by index-----");
        myList.add(2, 5);
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + "\t");
        }
        System.out.println();
        System.out.println("-----remove-----");
        myList.remove(2);
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + "\t");
        }
        System.out.println();
        System.out.println("-----size-----");
        System.out.println(myList.size());
        System.out.println("-----contain-----");
        System.out.println("is contained 3: " + myList.contains(3));
        System.out.println("is contained 10: " + myList.contains(10));
        System.out.println("-----index of-----");
        System.out.println("index of 3: " + myList.indexOf(3));
        System.out.println("index of 10: " + myList.indexOf(10));
        System.out.println("-----clone-----");
        MyList<Integer> newList = myList.clone();
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
