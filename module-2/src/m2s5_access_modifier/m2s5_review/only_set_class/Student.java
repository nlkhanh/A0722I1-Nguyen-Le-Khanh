package m2s5_access_modifier.m2s5_review.only_set_class;

public class Student {
    private String name = "john";
    private String classes = "C02";

    public Student() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}