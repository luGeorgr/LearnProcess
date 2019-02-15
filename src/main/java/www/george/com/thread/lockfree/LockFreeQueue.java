package www.george.com.thread.lockfree;

/**
 * @author rouqiu
 *
 */
public class LockFreeQueue {
    private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
    private Node head = new Node();
    private Node tail = head;
    public void enqueueV1(int val) {
        final Node q = new Node(val);
    }

}

class Node {
    public int val;
    public Node next;

    public Node(final int val, final Node node) {
        this.val = val;
        next = node;
    }

    public Node(final int val) {
        this(val, null);
    }

    public Node() {
        this(0);
    }
}
