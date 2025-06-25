import java.util.concurrent.atomic.AtomicBoolean;

class DisplayThread extends Thread {
    private String message;
    private AtomicBoolean running = new AtomicBoolean(true);

    public DisplayThread(String message) {
        this.message = message;
    }

    public void stopRunning() {
        running.set(false);
    }

    @Override
    public void run() {
        while (running.get()) {
            System.out.println(Thread.currentThread().getName() + ": " + message);
            try {
                Thread.sleep(1000); // 1 second delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        DisplayThread thread1 = new DisplayThread("Thread 1");
        DisplayThread thread2 = new DisplayThread("Thread 2");

        thread1.start();
        thread2.start();

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

        // Handling Ctrl-C
        /*Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                thread1.stopRunning();
                thread2.stopRunning();
                System.out.println("\nCtrl-C pressed. Exiting...");
            }
        });*/
    }
}