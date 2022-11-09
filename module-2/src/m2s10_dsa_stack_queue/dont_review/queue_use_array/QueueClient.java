package m2s10_dsa_stack_queue.dont_review.queue_use_array;

public class QueueClient {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(4);
        //queue.enqueue(4);
        //queue.displayAll();
        //queue.dequeue();
        //queue.displayAll();
        queue.enqueue(56);
        queue.displayAll();
        queue.enqueue(2);
        queue.displayAll();
        queue.enqueue(67);
        queue.displayAll();
        queue.enqueue(23);
        queue.displayAll();
        queue.dequeue();
        queue.displayAll();
        queue.dequeue();
        queue.displayAll();
    }
}
