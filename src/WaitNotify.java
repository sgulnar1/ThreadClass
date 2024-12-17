public class WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread("Thread 1") {
            public void run() {
                System.out.println(" Thread 1 start");
                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };

        Thread thread2 = new Thread("Thread 2") {
            public void run() {
                System.out.println(" Thread 2 start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (this) {
                    notify();
                }

            }
        };
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        System.out.println("state thread 1 " + thread1.getState());
    }
}
