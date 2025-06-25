import java.util.Random;

class SumThread extends Thread {
    private int[] array;
    private int startIndex;
    private int endIndex;
    private long partialSum;

    public SumThread(int[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public long getPartialSum() {
        return partialSum;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            partialSum += array[i];
        }
    }
}

public class Main2 {
    public static void main(String[] args) {
        // Generate random array of 1000 integers
        int[] numbers = new int[1000];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            numbers[i] = random.nextInt(100);
        }

        // Create and start 10 threads to calculate partial sums
        SumThread[] threads = new SumThread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new SumThread(numbers, i * 100, (i + 1) * 100);
            threads[i].start();
        }

        // Wait for all threads to finish
        try {
            for (int i = 0; i < 10; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Calculate total sum
        long totalSum = 0;
        for (int i = 0; i < 10; i++) {
            totalSum += threads[i].getPartialSum();
        }

        // Calculate average
        double average = (double) totalSum / 1000;

        // Display results
        System.out.println("Total Sum: " + totalSum);
        System.out.println("Average: " + average);
    }
}
