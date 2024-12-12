import java.util.Date;

public class RaceConditional {
    public static int a=0;
    public static void main(String[] args) throws InterruptedException {
        ThreadClass thread1 = new ThreadClass("thread 1");
        Runnable runnable = new RunnableClass();
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        System.out.println("main time: " + new Date().getTime());
        Thread.sleep(3000);
        System.out.println("a: " + a);
    }
}
