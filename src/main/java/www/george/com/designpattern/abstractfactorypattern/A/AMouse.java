package www.george.com.designpattern.abstractfactorypattern.A;

import www.george.com.designpattern.abstractfactorypattern.Mouse;

/**
 * @author rouqiu
 *
 */
public class AMouse implements Mouse {
    @Override
    public void canMove() {
        System.out.println("mouse A");
    }
}
