package www.george.com.process.pipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author rouqiu
 *
 */
public class ProcessSon {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String strLine = bfr.readLine();
            if (strLine != null) {
                System.out.println(strLine);//这个地方的输出在子进程控制台是无法输出的，只可以在父进程获取子进程的输出
            }else {
                return;
            }
        }
    }
}
