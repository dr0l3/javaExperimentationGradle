import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static Logger log = LogManager.getLogger();
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while(true){
            log.info("heheheh nice message number: " + i);
            i++;
            Thread.sleep(100);
        }
    }
}
