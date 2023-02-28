package m2s11_java_collection_framework.dont_review.comparable_comparator;

import java.util.Comparator;

public class AddressComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAddress().compareTo(o2.getAddress());
    }
}
