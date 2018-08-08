package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

/**
 * @author rouqiu
 *
 */
public class TreeMapTest {
    private TreeMap<Integer, Integer> mTreeMap;

    @Before
    public void setUp() {
        mTreeMap = new TreeMap<>();
    }

    @Test
    public void testGetFloor () {
        mTreeMap.put(5,0);
        mTreeMap.put(2,0);
        mTreeMap.put(7,0);
        mTreeMap.put(4,0);
        Assert.assertEquals((Integer) (2), mTreeMap.floorKey(3));
    }
}
