package www.george.com.tree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author rouqiu
 *
 */
public class RangeModuleTest {

    private RangeModule mRangeModule = new RangeModule();

    @Test
    public void addRange() {
        mRangeModule.addRange(0, 1);
        mRangeModule.addRange(2, 5);
        mRangeModule.addRange(10, 100);
        mRangeModule.addRange(-5, 4);
    }
}