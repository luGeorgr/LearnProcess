package www.george.com.designpattern.abstractfactorypattern;

import www.george.com.designpattern.abstractfactorypattern.A.AFactory;

/**
 * @author rouqiu
 *
 */
public class Main {
    public static void main(String[] argv) {
        AbstractFactory factory = new AFactory();
        Mouse mouse = factory.getMouse();
        KeyBoard keyBoard = factory.getKeyBoard();
        mouse.canMove();
        keyBoard.canKnock();
    }
}
