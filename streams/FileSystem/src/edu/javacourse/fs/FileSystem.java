package edu.javacourse.fs;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileSystem 
{
    public static void main(String[] args) throws Exception {
        File f = new File("nbproject");
        String[] l = f.list(new FilenameFilter(){
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith("p");
            }
        });
        
        for(String g : l) {
            System.out.println(g);
        }
     
        Path p = Paths.get("build.xml");
        Stream<String> lines = Files.lines(p);
        lines.forEach((s) -> System.out.println(s));
    }
    
}
