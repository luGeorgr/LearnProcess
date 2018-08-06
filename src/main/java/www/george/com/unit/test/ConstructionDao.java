package www.george.com.unit.test;

/**
 * @author rouqiu
 *
 */
public class ConstructionDao {
    private int val = 100;
    public ConstructionDao (int i) {
        val = i;
    }

    public ConstructionDao() {

    }

    public int getVal() {
        return val;
    }
}
