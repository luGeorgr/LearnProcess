package www.george.com.thread.lockfree;

import lombok.Getter;
import lombok.Setter;
import sun.misc.Unsafe;

/**
 * @author rouqiu
 *
 */
@Setter
@Getter
public class Node {
    private static final Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
    private static final long VALUE_OFFSET;

    static {
        try {
            VALUE_OFFSET = UNSAFE.objectFieldOffset
                    (Node.class.getDeclaredField("next"));
        } catch (Exception ex) { throw new Error(ex); }
    }

    private int value;
    private volatile Node next;

    public boolean cas(final Node )

}
