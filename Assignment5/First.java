import java.util.concurrent.atomic.AtomicBoolean;

public class First extends Thread
{
    String message;
    private AtomicBoolean running = new AtomicBoolean(true);

    First(String message)
    {
        this.message = message;
    }

    public void run()
    {
        //System.out.println("Thread is running");
        while (running.get()) {
            System.out.println(Thread.currentThread().getName() + ": " + message);
            try {
                Thread.sleep(1000); // 1 second delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        First f1 = new First("Thread 1");
        First f2 = new First("Thread 2");
        f1.start();
        f2.start();

        // Continuously print thread information
        while (true) {
            System.out.println("\nActive Threads:");
            for (Thread t : Thread.getAllStackTraces().keySet()) {
                System.out.println("  " + t.getName());
            }
            try {
                Thread.sleep(5000); // Display thread info every 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Thread t1 = new Thread("First Thread");
        // Thread t2 = new Thread("Second Thread");

        // while(true)
        // {
        //     String str1 = t1.getName();
        //     String str2 = t2.getName();
        //     System.out.println(str1);
        //     t1.start();
        //     System.out.println(str2);
        //     t2.start();
        // }
    }
}