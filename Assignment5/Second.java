import java.util.*;

public class Second extends Thread
{
    int[] arr;
    int startIndex;
    int endIndex;
    long partialSum;

    Second(int[] arr, int startIndex, int endIndex)
    {
        this.arr = arr;
        this.startIndex =startIndex;
        this.endIndex = endIndex;
    }

    long getPartialSum()
    {
        return partialSum;
    }

    public void run()
    {
        for(int i=startIndex; i<endIndex; i++)
        {
            partialSum += arr[i];
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[1000];
        Random rand = new Random();
        for(int i=0; i<1000; i++)
        {
            numbers[i] = rand.nextInt(100);
        }

        Second[] threads = new Second[10];
        for(int i=0; i<10; i++)
        {
            threads[i] = new Second(numbers, i * 100, (i+1) * 100);
            threads[i].start();
        }

        try
        {
            for(int i=0; i<10; i++)
            {
                threads[i].join();
            }
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }

        long totalSum = 0;
        for(int i=0; i<10; i++)
        {
            totalSum += threads[i].getPartialSum();
        }

        double avg = totalSum / 1000;

        System.out.println("Total Sum: " +totalSum);
        System.out.println("Average: " +avg);
    }
}
