import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class Main {
    private static Logger log = LogManager.getLogger();
    public static void main(String[] args) {
        Random r = new Random();
        int id = r.nextInt(10);
        while(true){
            int number = r.nextInt(100);
            log.info("Hello from {} the next random number is {}", id, number);
        }

        //this is apperently only feasable with logback and appenders in prudent-mode
    }
}
