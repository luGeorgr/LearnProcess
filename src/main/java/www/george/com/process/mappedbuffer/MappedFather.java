package www.george.com.process.mappedbuffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author rouqiu
 *
 */
public class MappedFather extends Thread {
    private String fileName;
    private FileChannel fileChannel;
    private MappedByteBuffer mappedByteBuffer;
    public MappedFather(String fn) throws IOException {
        fileName = fn;
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "r");
        fileChannel = randomAccessFile.getChannel();
        int size = (int) fileChannel.size();
        mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, 1024).load();
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(300);
                FileLock lock = null;
                lock = fileChannel.tryLock(0,1024,true);
                if (lock == null) {
                    System.err.println("Consumer:lock failed");
                    continue;
                }
                Thread.sleep(200);
                System.out.println("Consumer: "+mappedByteBuffer.getInt(0)+":"
                        + mappedByteBuffer.getInt(4)+":" +
                        mappedByteBuffer.getInt(8));
                lock.release();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws IOException {
        MappedFather mappedFather = new MappedFather("sharedMemory.bin");
        mappedFather.start();
    }
}
