import java.util.Date;

public class RunnableClass implements Runnable {
    private RaceConditional raceConditional;
    public RunnableClass(RaceConditional race) {
        raceConditional = race;
    }
    public RunnableClass() {
    }

    @Override
    public synchronized  void run() {
        System.out.println("Runnable class start date" + new Date().getTime());
        for (int i = 1; i <= 100000; i++)
        synchronized (raceConditional) {
                raceConditional.increment();
            }
        System.out.println("Runnable class: " + raceConditional.getA());
        System.out.println("Runnable class end date" + new Date().getTime());
    }
}
