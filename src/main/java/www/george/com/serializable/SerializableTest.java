package www.george.com.serializable;

import java.io.*;

public class SerializableTest {
    public static void main(String[] argv) {
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("output.txt"));
            Bean bean = (Bean) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println(bean.getName() + bean.getAge());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
