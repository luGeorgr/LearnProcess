package www.george.com.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author rouqiu
 *
 */
public class GamePlayIH implements InvocationHandler {
    private Class cls = null;
    private Object obj = null;

    public GamePlayIH(final Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args)
            throws Throwable {
        return method.invoke(obj, args);
    }
}
