package www.george.com.thread.lockfree;

import sun.misc.Unsafe;

/**
 * @author rouqiu
 *
 */
public class LockFreeQueue<T> {
    private volatile Node<T> head;
    private volatile Node<T> tail;

    public LockFreeQueue() {
        this.head = this.tail = new Node<>(null);
    }

//    public void add(final T value) {
//
//    }
//
//    public T remove() {
//
//    }
//
//    public int size() {
//
//    }
//
//    public boolean empty() {
//
//    }

    private static class Node<T> {
        private T value;
        private volatile Node<T> next;
        private static final Unsafe UNSAFE;
        private static final long VALUE_OFFSET;
        private static final long NEXT_OFFSET;

        static {
            try {
                UNSAFE = Unsafe.getUnsafe();
                Class<?> k = Node.class;
                VALUE_OFFSET = UNSAFE.objectFieldOffset(k.getDeclaredField("value"));
                NEXT_OFFSET = UNSAFE.objectFieldOffset(k.getDeclaredField("next"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        public Node(final T value, final Node<T> next) {
            this(next);
            this.value = value;
        }

        public Node(final Node<T> next) {
            this.next = next;
        }

    }
}

