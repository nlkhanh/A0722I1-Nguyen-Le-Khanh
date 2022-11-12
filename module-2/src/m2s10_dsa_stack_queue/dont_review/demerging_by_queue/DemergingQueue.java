package m2s10_dsa_stack_queue.dont_review.demerging_by_queue;


import java.util.LinkedList;
import java.util.Queue;

public class DemergingQueue {
    private static Queue<Student> students;
    private static Queue<Student> male;
    private static Queue<Student> female;

    static {
        students = new LinkedList<>();
        male = new LinkedList<>();
        female = new LinkedList<>();
    }

    public DemergingQueue() {
    }

    public void add(Student student) {
        if (student.isMale()) {
            male.offer(student);
            return;
        }
        female.offer(student);
    }

    public void combineStudentList() {
        while (!female.isEmpty()) {
            students.offer(female.poll());
        }
        while (!male.isEmpty()) {
            students.offer(male.poll());
        }
    }

    public void displayAll() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
