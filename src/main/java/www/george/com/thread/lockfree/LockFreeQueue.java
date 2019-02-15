package www.george.com.thread.lockfree;

/**
 * @author rouqiu
 *
 */
public class LockFreeQueue {
    private Node head = new Node();
    private Node tail = head;
    public void enqueueV1(int val) {
        final Node q = new Node(val);
        Node p;
        do {
            p = tail;
        } while ()
    }

}

