package www.george.com.designpattern.abstractfactorypattern.B;

import www.george.com.designpattern.abstractfactorypattern.KeyBoard;

/**
 * @author rouqiu
 *
 */
public class BKeyBoard implements KeyBoard {
    @Override
    public void canKnock() {
        System.out.println("B keyboard");
    }
}
