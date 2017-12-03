import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LogMdc {
    private static Logger log = LogManager.getLogger();
    private static ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(8);
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            final int val = i;
            executor.submit(() -> logSomeStuff(val));
        }
//        executor.awaitTermination(1, TimeUnit.SECONDS);
        executor.shutdown();
    }

    public static void logSomeStuff(int id){
//        log.info("stuffely stuf {} ", 1);
        ThreadContext.put("transaction.id", String.valueOf(id));
        ThreadContext.put("hello", "dog");
        log.info("hello");
        log.info("world");
        ThreadContext.clearAll();
    }
}
