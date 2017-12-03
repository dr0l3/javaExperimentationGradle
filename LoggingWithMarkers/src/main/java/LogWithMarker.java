import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class LogWithMarker {
    private static Logger log = LogManager.getLogger();
    public static void main(String[] args) {
        Marker markers = MarkerManager.getMarker("RandomName");
        Marker another = MarkerManager.getMarker("OtherName");
        log.info(markers,"hehhee {}", 1);
        log.info(another, "heheh {}", 2);
        //what i really wanted was MDC, lets ust that instead
    }
}
