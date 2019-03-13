package www.george.com.jvm;

/**
 * @author rouqiu
 *
 */
public class PassiveInit {
    public static void main(String[] argv) {
        System.out.println(Sub.VALUE);
        Super[] array = new Super[10];
    }
}

class Super {
   static {
       System.out.println("Super init");
   }
   public static final int VALUE = 1; //注意final的区别， final 会使值放到PassiveInit的常量池中， 从而不需要类的初始化
}

class Sub extends Super{
    static {
        System.out.println("Sub init");
    }
}