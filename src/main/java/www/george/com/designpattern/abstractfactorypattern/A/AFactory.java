package www.george.com.designpattern.abstractfactorypattern.A;

import www.george.com.designpattern.abstractfactorypattern.AbstractFactory;
import www.george.com.designpattern.abstractfactorypattern.KeyBoard;
import www.george.com.designpattern.abstractfactorypattern.Mouse;

/**
 * @author rouqiu
 *
 */
public class AFactory extends AbstractFactory {
    @Override
    public Mouse getMouse() {
        return new AMouse();
    }

    @Override
    public KeyBoard getKeyBoard() {
        return new AKeyBoard();
    }
}
