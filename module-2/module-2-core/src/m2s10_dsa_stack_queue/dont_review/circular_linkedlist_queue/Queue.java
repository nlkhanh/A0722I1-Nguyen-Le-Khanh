package m2s10_dsa_stack_queue.dont_review.circular_linkedlist_queue;

public class Queue {
    private Node front;
    private Node rear;

    public Queue() {
    }

    private class Node {
        private int data;
        private Node link;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }
    }

    public void enQueue(int data) {
        Node newNode = new Node(data);
        if (front == null) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.link = front;
            rear.link = newNode;
            rear = newNode;
        }
    }

    public Node deQueue() {
        if (front == null) {
            return null;
        } else if (rear == front) {
            Node temp = front;
            front = null;
            rear = null;
            return temp;
        } else {
            Node temp = front;
            front = front.link;
            rear.link = front;
            return temp;
        }
    }

    public void displayQueue() {
        if (front == null) {
            System.out.println((Object) null);
        } else {
            Node current = front;
            do {
                System.out.println(current.getData());
                current = current.link;
            } while (current.link != front.link);
        }
    }
}
