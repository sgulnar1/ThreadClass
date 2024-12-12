import java.util.Date;

public class ThreadClass extends Thread {

    public ThreadClass(ThreadGroup threadGroup, String name) {
        super(threadGroup, name);
    }

    public ThreadClass(String name) {
        super(name);
    }

    @Override
    public synchronized void run() {
//        System.out.println("thread....");
//        Thread.yield();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println("Thread class start date" + new Date().getTime());
        for (int i = 1; i <= 100000; i++)
            synchronized (this) {
            RaceConditional.a++;
            }
        System.out.println("Thread class: " + RaceConditional.a);
        System.out.println("Thread class end date" + new Date().getTime());

    }
}
