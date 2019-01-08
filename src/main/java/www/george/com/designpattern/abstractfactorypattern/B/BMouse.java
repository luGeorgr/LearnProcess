package www.george.com.designpattern.abstractfactorypattern.B;

import www.george.com.designpattern.abstractfactorypattern.Mouse;

/**
 * @author rouqiu
 *
 */
public class BMouse implements Mouse {
    @Override
    public void canMove() {
        System.out.println("B mouse");
    }
}
