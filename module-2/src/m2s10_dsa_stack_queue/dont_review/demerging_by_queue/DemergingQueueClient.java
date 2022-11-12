package m2s10_dsa_stack_queue.dont_review.demerging_by_queue;

public class DemergingQueueClient {
    public static void main(String[] args) {
        Student[] students = new Student[5];

        students[0] = new Student("khanh", true, 0);
        students[1] = new Student("xuan", false, 1);
        students[2] = new Student("duy", true, 2);
        students[3] = new Student("my", false, 3);
        students[4] = new Student("ba", false, 4);

        DemergingQueue demergingQueue = new DemergingQueue();
        for (Student student : students) {
            demergingQueue.add(student);
        }
        demergingQueue.combineStudentList();
        demergingQueue.displayAll();
    }
}
