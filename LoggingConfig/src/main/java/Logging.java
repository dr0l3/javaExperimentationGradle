import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Optional;

public class Logging {
    private static final Logger log = LogManager.getLogger();
    public static void main(String[] args) {
        log.info("hello");
        try{
            throw new RuntimeException("Hello again");
        } catch (Exception e){
            log.error(e);
        }

        try{
            hello();
        } catch (Exception e){
            log.error(e);
        }

        log.info("Hello {}", "world");
        log.info("Hello {}", 3);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("Workd");
        strings.add("this is dog");
        log.info("Stuff {}", strings);
        Optional<String> empty = Optional.empty();
        Optional<String> notEmpty = Optional.of("Hello");
        log.info("empty {}", empty);
        log.info("nonempty {}", notEmpty);

        for (int i = 0; i <1000; i++) {
            strings.add(Integer.toString(i));
        }
        log.info("very long array {}", strings.size());
    }

    public static String hello(){
        try{
            throw new RuntimeException("Hello again");
        } catch (Exception e){
            log.error("WAAAAH",e);
        }
        return "Hello";
    }


}

