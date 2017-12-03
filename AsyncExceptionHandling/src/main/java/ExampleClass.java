import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExampleClass {
    private static ScheduledExecutorService executorService;
    private static List<Future<?>> futures;
    public static void main(String[] args) {
        futures = new CopyOnWriteArrayList<>();
        executorService = new ScheduledThreadPoolExecutor(4);
        executorService.scheduleAtFixedRate(ExampleClass::pollAndPrint, 0, 1, TimeUnit.SECONDS);
        Future<?> lol = executorService.submit(ExampleClass::fantastic);
        futures.add(lol);
        try {
            Thread.sleep(2000);
            Future<?> fut2 = executorService.submit(ExampleClass::fantastic);
            futures.add(fut2);
            executorService.awaitTermination(5, TimeUnit.SECONDS);
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        try {
//
//            ListenableScheduledFuture<?> f = exe.schedule(() -> fantastic(),0, TimeUnit.SECONDS);
//            f.addListener(() -> System.out.println("heheh"), executorService);
//            executorService.shutdown();
//        } catch (Exception e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
    }

    private static void pollAndPrint(){
        futures.forEach(fut -> {
            if(fut.isDone()){
                futures.remove(fut);
                try {
                    fut.get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void fantastic(){
        throw new RuntimeException("WAAAAAAAAAAAAH");
    }
}
