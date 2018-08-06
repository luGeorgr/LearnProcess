package www.george.com.unit.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

/**
 * @author rouqiu
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Construction.class})
public class ConstructionTest {

    private final Construction mConstruction = new Construction();

    @Before
    public void before() throws Exception {
        ConstructionDao dao = new ConstructionDao();
        PowerMockito.whenNew(ConstructionDao.class).withArguments(10).thenReturn(dao);
    }

    @Test
    public void testNewInstance() {
        ConstructionDao dao = mConstruction.newInstance();
        Assert.assertEquals(100, dao.getVal());
    }
}