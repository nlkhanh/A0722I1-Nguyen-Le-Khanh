package m2s11_java_collection_framework.dont_review.comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student("Nam", 38, "A");
        Student student2 = new Student("Tung", 30, "A");
        Student student3 = new Student("Anh", 38, "C");
        Student student = new Student("An", 30, "A");

        List<Student> lists = new ArrayList<>();
        lists.add(student);
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);
        Collections.sort(lists);
        for (Student st : lists) {
            System.out.println(st);
        }

        AgeComparator ageComparator = new AgeComparator();
        lists.sort(ageComparator);
        System.out.println("----age----");
        for (Student st : lists) {
            System.out.println(st);
        }
        System.out.println("----age----");
        AddressComparator addressComparator = new AddressComparator();
        lists.sort(addressComparator);
        for (Student st : lists) {
            System.out.println(st);
        }
    }
}
