package www.george.com.designpattern.abstractfactorypattern.B;

import www.george.com.designpattern.abstractfactorypattern.AbstractFactory;
import www.george.com.designpattern.abstractfactorypattern.KeyBoard;
import www.george.com.designpattern.abstractfactorypattern.Mouse;

/**
 * @author rouqiu
 *
 */
public class BFactory extends AbstractFactory {
    @Override
    public Mouse getMouse() {
        return new BMouse();
    }

    @Override
    public KeyBoard getKeyBoard() {
        return new BKeyBoard();
    }
}
