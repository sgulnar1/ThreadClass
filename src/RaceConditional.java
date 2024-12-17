import java.util.Date;

public class RaceConditional {
    private volatile int a;

    public int getA() {
        return a;
    }

    public void increment() {
        this.a++;
    }

    public static void main(String[] args) throws InterruptedException {
        RaceConditional race = new RaceConditional();
        ThreadClass thread1 = new ThreadClass("thread 1", race);
        Runnable runnable = new RunnableClass(race);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        System.out.println("main time: " + new Date().getTime());
        Thread.sleep(3000);
        System.out.println("a: " + race.getA());
    }
}
