package m2s11_java_collection_framework.review.arraylist_linkedlist.linked_list;

import m2s11_java_collection_framework.review.arraylist_linkedlist.Product;

import java.util.*;

public class ProductManagerLinkedList {
    private static List<Product> products;

    static {
        products = new LinkedList<>();
    }

    public ProductManagerLinkedList() {
    }

    public void add(Product product) {
        products.add(product);
    }

    public void set(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                Scanner input = new Scanner(System.in);
                int choice;
                do {
                    System.out.println("Choose what you want to edit?");
                    System.out.println("1. Name");
                    System.out.println("2. Price");
                    System.out.println("Enter your choice: ");
                    choice = Integer.parseInt(input.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.println("Enter a new name: ");
                            String newName = input.nextLine();
                            product.setName(newName);
                            break;
                        case 2:
                            System.out.println("Enter a new price: ");
                            long newPrice = Long.parseLong(input.nextLine());
                            product.setPrice(newPrice);
                            break;
                        default:
                            System.out.println("Invalid input!");
                    }
                } while (choice != 1 && choice != 2);
                System.out.println("After edit: " + product);
            }
        }
    }

    public Product remove(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                return product;
            }
        }
        return null;
    }

    public void displayAll() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public Product find(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public void increasingSorted() {
        Collections.sort(products);
    }

    public void decreasingSorted() {
        products.sort(Collections.reverseOrder());
    }
}
