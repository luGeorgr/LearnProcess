package www.george.com.process.pipe;

import java.io.IOException;

/**
 * @author rouqiu
 *
 */
public class ProcessFather {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("java", "www.george.com.process.pipe.ProcessSon");
        Process p = pb.start();
        StringBuilder sbuilder = new StringBuilder();
        for(int k=0;k<1;k++){
            sbuilder.append("hello");
        }

        int outSize = 1;
        TestOut out[] = new TestOut[outSize];
        for(int i=0;i<outSize;i++){
            out[i] = new TestOut(p,sbuilder.toString().getBytes());
            new Thread(out[i]).start();
        }

        int inSize = 1;
        TestIn in[] = new TestIn[inSize];
        for(int j=0;j<inSize;j++){
            in[j] = new TestIn(p);
            new Thread(in[j]).start();
        }
        Thread.sleep(1000000);
    }
}
