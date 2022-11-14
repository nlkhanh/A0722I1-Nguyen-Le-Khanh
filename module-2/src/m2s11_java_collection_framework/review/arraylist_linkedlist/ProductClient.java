package m2s11_java_collection_framework.review.arraylist_linkedlist;

import m2s11_java_collection_framework.review.arraylist_linkedlist.array_list.ProductManagerArrayList;
import m2s11_java_collection_framework.review.arraylist_linkedlist.linked_list.ProductManagerLinkedList;

public class ProductClient {
    public static void main(String[] args) {
        System.out.println("-----Array List-----");
        Product[] products = new Product[5];

        products[0] = new Product("car", 0, 1250000000);
        products[1] = new Product("bicycle", 1, 20000000);
        products[2] = new Product("motorbike", 2, 100000000);
        products[3] = new Product("bus", 3, 546000000);
        products[4] = new Product("taxi", 4, 890000000);

        ProductManagerArrayList productArrayList = new ProductManagerArrayList();

        for (Product product : products) {
            productArrayList.add(product);
        }

        productArrayList.displayAll();
        System.out.println("-----increase sorted-----");
        productArrayList.increasingSorted();
        productArrayList.displayAll();
        System.out.println("-----decrease sorted-----");
        productArrayList.decreasingSorted();
        productArrayList.displayAll();
        System.out.println("-----set-----");
        productArrayList.set(2);
        productArrayList.displayAll();
        System.out.println("-----find-----");
        System.out.println(productArrayList.find("bus"));
        System.out.println("-----remove-----");
        System.out.println("Product be removed: " + productArrayList.remove(3));
        productArrayList.displayAll();
        System.out.println("----Linked List-----");
        Product[] secondProducts = new Product[6];

        secondProducts[0] = new Product("car", 0, 1250000000);
        secondProducts[1] = new Product("bicycle", 1, 20000000);
        secondProducts[2] = new Product("motorbike", 2, 100000000);
        secondProducts[3] = new Product("bus", 3, 546000000);
        secondProducts[4] = new Product("taxi", 4, 890000000);
        secondProducts[5] = new Product("ambullance", 4, 1300000000);

        ProductManagerLinkedList productLinkedList = new ProductManagerLinkedList();

        for (Product product : secondProducts) {
            productLinkedList.add(product);
        }

        productLinkedList.displayAll();
        System.out.println("-----increase sorted-----");
        productLinkedList.increasingSorted();
        productLinkedList.displayAll();
        System.out.println("-----decrease sorted-----");
        productLinkedList.decreasingSorted();
        productLinkedList.displayAll();
        System.out.println("-----set-----");
        productLinkedList.set(2);
        productLinkedList.displayAll();
        System.out.println("-----find-----");
        System.out.println(productLinkedList.find("bus"));
        System.out.println("-----remove-----");
        System.out.println("Product be removed: " + productLinkedList.remove(3));
        productLinkedList.displayAll();
    }
}
