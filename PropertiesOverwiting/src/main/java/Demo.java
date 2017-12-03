import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.properties.EncryptableProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) throws IOException {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("hello");
        Properties props = new EncryptableProperties(encryptor);
        props.load(new FileInputStream("C:\\dev\\JavaExplorationWithGradle\\PropertiesOverwiting\\src\\main\\resources\\hello.properties"));
        Properties p2 = new Properties();
        p2.putAll(props);
        Properties p3 = new Properties();
        props.stringPropertyNames().stream().forEach(pname -> p3.put(pname, props.getProperty(pname)));
        System.out.println(props.getProperty("someproperty"));
        System.out.println(p2.getProperty("someproperty"));
        System.out.println(p3.getProperty("someproperty"));
    }
}
