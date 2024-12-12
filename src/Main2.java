public class Main2 {
    public static void main(String[] args) throws InterruptedException {

        ThreadGroup threadGroup1 = new ThreadGroup("thread group 1");
        ThreadGroup threadGroup2 = new ThreadGroup(threadGroup1,"thread group 2");
        threadGroup1.parentOf(threadGroup2);
        ThreadClass thread1 = new ThreadClass( threadGroup1, "thread 1");
        Runnable runnable = new RunnableClass();
        Thread thread2 = new Thread(threadGroup2, runnable);
        System.out.println("Thread 1 new: " + thread1.getState());
        thread1.start();
        System.out.println("Thread 1 runnable " + thread1.getState());
        Thread.sleep(1000);
        System.out.println("Thread 1 time waiting " + thread1.getState());
        thread2.start();
        thread2.setPriority(8);
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().setPriority(7);
        System.out.println("thread1 priority: " + thread1.getPriority());
        System.out.println("thread2 priority: " + thread2.getPriority());
        thread1.join(2000);
        Thread.sleep(6000);
        thread1.interrupt();

        System.out.println("Thread 1 terminated: " + thread1.getState());
        System.out.println("Thread 1 interrupt: " + thread1.isInterrupted());

        thread1.setPriority(10);
        System.out.println("thread 1 is alive: " + thread1.isAlive());
        System.out.println("thread 2 is alive: " + thread2.isAlive());
    }
}
