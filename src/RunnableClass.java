import java.util.Date;

public class RunnableClass implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable class start date" + new Date().getTime());
        for (int i = 1; i <= 100000; i++)
            synchronized (this) {
                RaceConditional.a++;
            }
        System.out.println("Runnable class: " + RaceConditional.a);
        System.out.println("Runnable class end date" + new Date().getTime());
    }
}
