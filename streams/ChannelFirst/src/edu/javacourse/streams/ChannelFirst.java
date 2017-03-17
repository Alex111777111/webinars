package edu.javacourse.streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelFirst {

    public static void main(String[] args) throws Exception {
        FileInputStream fis
                = new FileInputStream("/Users/antonsaburov/Downloads/MP4/servlets20161112.mp4");
        FileOutputStream fos = new FileOutputStream("test.mp4");
        FileChannel outChannel = fos.getChannel();
//        ByteBuffer outBuf = ByteBuffer.allocate(1000);
        FileChannel inChannel = fis.getChannel();
        
//        Reader reader = new InputStreamReader(fis);
                
//        ByteBuffer inBuf = ByteBuffer.allocate(1000);
//        int read = inChannel.read(inBuf);
//        while (read != -1) {
//            inBuf.flip();
//            while (inBuf.hasRemaining()) {
//                byte b = inBuf.get();
//                outBuf.put(inBuf);
//            }
//            inBuf.clear();
//            outBuf.flip();
//            outChannel.write(outBuf);
//            outBuf.clear();
//            read = inChannel.read(inBuf);
//        }
        for(int i=0; i<100; i++) {
            inChannel.transferTo(100*i, 100, outChannel);
        }
        fis.close();
        fos.close();
    }

}
