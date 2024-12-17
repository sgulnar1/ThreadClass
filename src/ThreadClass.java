import java.util.Date;

public class ThreadClass extends Thread {
    private RaceConditional raceConditional;

    public ThreadClass(ThreadGroup threadGroup, String name) {
        super(threadGroup, name);
    }

    public ThreadClass(String name) {
        super(name);
    }

    public ThreadClass(String s, RaceConditional race) {
        super(s);
        this.raceConditional = race;

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
        //synchronized (raceConditional) {
            for (int i = 1; i <= 100000; i++)
                raceConditional.increment();
       // }
        System.out.println("Thread class: " + raceConditional.getA());
        System.out.println("Thread class end date" + new Date().getTime());

    }
}
