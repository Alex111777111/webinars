package edu.javacourse.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelExample {

    public static void main(String[] args) throws Exception {
//        demoChannel();
        transferDemo();
    }
    
    public static void demoChannel() throws Exception {
        FileInputStream fis = new FileInputStream("/Users/antonsaburov/Downloads/MP4/servlets20161112.mp4");
        FileOutputStream fos = new FileOutputStream("new.mp4");

        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();
        ByteBuffer inBb = ByteBuffer.allocate(4096);
        ByteBuffer outBb = ByteBuffer.allocate(4096);

        int r = inChannel.read(inBb);
        while (r != -1) {
            inBb.flip();
            while (inBb.hasRemaining()) {
                byte get = inBb.get();
                outBb.put(get);
            }
            outBb.flip();
            outChannel.write(outBb);
            inBb.clear();
            outBb.clear();
            r = inChannel.read(inBb);
        }

        fis.close();
        fos.close();
    }

    public static void transferDemo() throws Exception {
        FileInputStream fis = new FileInputStream("/Users/antonsaburov/Downloads/MP4/servlets20161112.mp4");
        FileOutputStream fos = new FileOutputStream("new.mp4");

        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();
        
        inChannel.transferTo(0, inChannel.size(), outChannel);
//        outChannel.transferFrom(inChannel, 0, inChannel.size());
       
        fis.close();
        fos.close();
    }
}
