import java.util.*;

interface Java_Array {
    void Array_reverse(int arr[]);
    void array_copy(int arr[]);
    void array_max(int arr[]);
}

public class arrayInterface implements Java_Array {
    public void Array_reverse(int arr[])
    {
        //int n = arr.length;
        System.out.println("\nArray in reverse order: ");
        for(int i=arr.length-1; i>=0; i--)
        {
            System.out.print(arr[i]+ " ");
        }
    }

    public void array_copy(int arr[])
    {
        System.out.println("\n\nCopying array: ");
        int[] arr2 = new int[arr.length];

        for(int i=0; i<arr.length; i++)
        {
            arr2[i] = arr[i];
        }

        System.out.println("Copied array: ");
        for(int i=0; i<arr.length; i++)
        {
            System.out.print(arr2[i]+ " ");
        }
    }

    public void array_max(int arr[])
    {
        int max = arr[0];

        for(int i=1; i<arr.length; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            }
        }
        
        System.out.println("\n\nMax element in array is: " +max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.print("Enter the elements of array: ");
        for(int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();
        }
        //System.out.println(arr.length);

        arrayInterface arrayOne = new arrayInterface();
        arrayOne.Array_reverse(arr);
        arrayOne.array_copy(arr);
        arrayOne.array_max(arr);
    }
}