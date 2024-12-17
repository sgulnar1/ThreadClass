import java.util.function.Function;

public class Deadlock {
    public static void main(String[] args) throws InterruptedException {
        Deadlock deadlock1 = new Deadlock();
        Deadlock deadlock2 = new Deadlock();
        System.out.println(deadlock1.hashCode());
        Thread thread1 = new Thread("Thread 1") {
            public void run() {
                System.out.println(" Thread 1 start");
                synchronized (deadlock1) {
                    System.out.println(" Thread 1 deadlock1");
                    synchronized (deadlock2) {
                        System.out.println(" Thread 1 deadlock2");
                    }
                }
            }
        };
        Thread thread2 = new Thread("Thread 2") {
            public void run() {
                System.out.println(" Thread 2 start");
                synchronized (deadlock2) {
                    System.out.println(" Thread 2 deadlock2");
                    synchronized (deadlock1) {
                        System.out.println(" Thread 2 deadlock1");
                    }
                }
            }
        };
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        System.out.println("state: " + thread1.getState());
    }
}
