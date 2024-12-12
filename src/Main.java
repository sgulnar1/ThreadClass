import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ThreadClass thread = new ThreadClass("thread first");
        System.out.println("threa");
        Runnable runnable = new RunnableClass();
        Thread thread1 = new Thread(runnable);
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread.run();
        thread.run();
        thread.run();
        thread.run();
        thread1.start();
        Runnable runnable1 = () -> {
            if (true)
                throw new RuntimeException();
            for (int i = 1; i <= 20; i++)
                System.out.println("Runnable: " + i);
        };
        Thread thread2 = new Thread(runnable1);
        thread2.start();
        Thread thread3 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 1; i <= 20; i++)
                System.out.println("Thread : " + i);

        });
        thread3.start();

        System.out.println("active: " + Thread.activeCount());
        Thread[] threads = new Thread[Thread.activeCount()];
        Thread.enumerate(threads);

        System.out.println("Threads: " + Arrays.toString(threads));
        thread1.setName("my thread");

        System.out.println("thread1 name: " + thread1.getName());
        System.out.println("thread name: " + thread.getName());
    }
}
