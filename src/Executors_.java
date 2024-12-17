import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class Executors_ {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.submit(() -> {
            try {
                System.out.println("runnable start 1");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.submit(() -> {
            try {
                System.out.println("runnable start 2");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.awaitTermination(3000, TimeUnit.MILLISECONDS);
        executorService.submit(() -> {
            try {
                System.out.println("runnable start 3");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Callable callable4 = () -> {
            System.out.println("callable start 4");
            Thread.sleep(3000);
            return null;
        };
        Callable callable5 = () -> {
            System.out.println("callable start 5");
            Thread.sleep(3000);
            return null;
        };
        List<Callable<Object>> callables = new ArrayList<>();
        callables.add(callable4);
        callables.add(callable5);
        executorService.invokeAll(callables);
  }
}
