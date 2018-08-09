package www.george.com.unit.test.power.mock.staticclass;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author rouqiu
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({SimpleConfig.class})
public class HelloWorldTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGreeting() {
        PowerMockito.mockStatic(SimpleConfig.class);
        PowerMockito.when(SimpleConfig.getGreeting()).thenReturn("Hello");
        PowerMockito.when(SimpleConfig.getTarget()).thenReturn("World");

        Assert.assertEquals("Hello World", new HelloWorld().greeting());
    }
}