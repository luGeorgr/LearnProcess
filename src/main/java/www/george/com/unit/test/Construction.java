package www.george.com.unit.test;

/**
 * @author rouqiu
 *
 */
public class Construction {
    public ConstructionDao newInstance() {
        ConstructionDao a = new ConstructionDao(10);
        return a;
    }
}
