package edu.javacourse.io;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class FileFirst {

    public static void main(String[] args) throws Exception {
        demoInputOutput();
        demoReadWrite();
        encodeDemo();
    }

    public static void demoInputOutput() {
        try (   InputStream is = 
                        new FileInputStream("/Users/antonsaburov/Downloads/MP4/servlets20161112.mp4");
                OutputStream os = new FileOutputStream("test.mp4", true)) {

            byte[] buffer = new byte[4096];
            int r = is.read(buffer);
            while (r != -1) {
                os.write(buffer, 0, r);
                r = is.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        is.close();
//        os.close();        
    }
    
    public static void demoReadWrite() throws Exception {
        Reader r = new FileReader("build.xml");
        Writer w = new FileWriter("test.xml");
        
        char[] buffer = new char[4096];
        int c = r.read(buffer);
        while(c != -1) {
            w.write(buffer, 0, c);
            c = r.read(buffer);
        }
        r.close();
        w.close();
    } 
    
    public static void encodeDemo() throws Exception {
        FileInputStream fis = new FileInputStream("test.xml");
        Reader fr = new InputStreamReader(fis, "utf-8");
        BufferedReader br = new BufferedReader(fr);
        
        String line = br.readLine();
        while(line != null) {
            System.out.println(line);
            line = br.readLine();
        }
        br.close();
        fr.close();
        fis.close();
    }

    public static void demoMemory() {
        ByteArrayInputStream bais = new ByteArrayInputStream(new byte[10]); 
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
    }
}
