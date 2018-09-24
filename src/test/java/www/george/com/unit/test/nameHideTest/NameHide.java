package www.george.com.unit.test.nameHideTest;

import org.junit.Assert;
import org.junit.Test;
import www.george.com.nameHideTest.Base;
import www.george.com.nameHideTest.Derived;

public class NameHide {
    @Test
    public void testNameHide() {
        Base derived = new Derived();
        derived.f();
    }
}
