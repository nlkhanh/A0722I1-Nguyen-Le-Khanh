package m2s10_dsa_stack_queue.dont_review.circular_linkedlist_queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue myQueue = new Queue();

        myQueue.displayQueue();

        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        myQueue.enQueue(4);
        myQueue.enQueue(5);

        myQueue.displayQueue();

        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.deQueue();

        System.out.println("---------");
        myQueue.displayQueue();
    }
}
