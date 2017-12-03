import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class LogginChangeAtRuntime {
    private static final Logger log = LogManager.getLogger();
    public static void main(String[] args) {
        log.info("hello");
        Configurator.initialize(null,"C:\\TestFolder\\log4j2.xml");
        log.info("hello again");
    }
}
