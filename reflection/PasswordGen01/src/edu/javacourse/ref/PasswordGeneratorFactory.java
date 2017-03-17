package edu.javacourse.ref;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class PasswordGeneratorFactory {

    public static PasswordGenerator getPasswordGenerator() {
        try {
            String clazz = getGenerator();
            Class<?> genClass = Class.forName(clazz);
//            System.out.println(genClass.getCanonicalName());
            PasswordGenerator generator = (PasswordGenerator)genClass.newInstance();
            return generator;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return new PasswordGeneratorFirst();
    }

    private static String getGenerator() throws Exception {
        Properties p = new Properties();
        p.load(new FileReader("generator.properties"));
        return p.getProperty("generator");
    }
}
