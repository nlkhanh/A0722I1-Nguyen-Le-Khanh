package m2s10_dsa_stack_queue.dont_review.demerging_by_queue;

public class Student {
    private String name;
    private boolean gender;
    private int id;

    public Student(String name, boolean gender, int id) {
        this.name = name;
        this.gender = gender;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMale() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", id=" + id +
                '}';
    }
}
