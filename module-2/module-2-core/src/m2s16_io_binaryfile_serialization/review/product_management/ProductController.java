package m2s16_io_binaryfile_serialization.review.product_management;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductController {
    private static final String FILE_PATH = "E:\\codegym\\exercises\\A0722I1-Nguyen-Le-Khanh\\module-2\\src\\m2s16_io_binaryfile_serialization\\review\\product_management\\products.txt";

    public static void write(List<Product> products) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutput = new FileOutputStream(FILE_PATH);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
        objectOutput.writeObject(products);
        objectOutput.close();
        fileOutput.close();
    }

    public static List<Product> read() throws IOException, ClassNotFoundException {
        FileInputStream fileInput = new FileInputStream(FILE_PATH);
        ObjectInputStream objectInput = new ObjectInputStream(fileInput);
        List<Product> products = (List<Product>) objectInput.readObject();
        objectInput.close();
        fileInput.close();
        return products;
    }

    public static void add(Product product) throws IOException, ClassNotFoundException {
        List<Product> products = read();
        products.add(product);
        write(products);
    }

    public static void displayAll() throws IOException, ClassNotFoundException {
        List<Product> products = read();
        System.out.println(products);
    }

    public static void find(String productCode) throws IOException, ClassNotFoundException {
        List<Product> products = read();
        for (Product product : products) {
            if (product.getCode().equals(productCode)) {
                System.out.println(product);
                return;
            }
        }
        System.out.println("Product is not exist!");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Product> products = new ArrayList<>();
        products.add(new Product("111", "aaa", "AAA", 11));
        products.add(new Product("222", "bbb", "BBB", 12));
        products.add(new Product("333", "ccc", "CCC", 13));
        products.add(new Product("444", "ddd", "DDD", 14));
        products.add(new Product("555", "eee", "EEE", 15));
        write(products);
        System.out.println("Before add: ");
        displayAll();
        add(new Product("666", "fff", "FFF", 16));
        System.out.println("After add:");
        displayAll();
        System.out.println("Find product have code 222:");
        find("222");
        System.out.println("Find product have code 777:");
        find("777");
    }
}
