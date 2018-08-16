package leetcode;

public class LeetCode622 {

    private int front;
    private int rear;
    private int[] queue;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public LeetCode622(int k) {
        queue = new int[k+1];
        front = rear = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        queue[front] = value;
        front = (front + 1) % queue.length;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear + 1) % queue.length;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[rear];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        return queue[(front + (queue.length - 1)) % queue.length];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return rear == front;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (front + 1) % queue.length == rear;
    }
}