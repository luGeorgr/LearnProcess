package www.george.com.designpattern.abstractfactorypattern.A;

import www.george.com.designpattern.abstractfactorypattern.KeyBoard;

/**
 * @author rouqiu
 *
 */
public class AKeyBoard implements KeyBoard {
    @Override
    public void canKnock() {
        System.out.println("A keyboard");
    }
}
