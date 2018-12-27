public class Test {
    public static void main(String[] args) {
        System.out.println(test());
    }

    public static String test() {
        while (true) {
            try {
                System.out.println("try block");
                break;
            } finally {
                System.out.println("finally block");
            }
        }
        return "";
    }
}