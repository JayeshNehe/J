//import java.util.*;
import java.io.*;

class student
{
    int roll_number;
    String name;
    float percentage;

    student()
    {

    }

    student(int roll_number, String name, float percentage)
    {
        this.roll_number = roll_number;
        this.name = name;
        this.percentage = percentage;
    }

    public void display()
    {
        System.out.print("\nRoll number: " +roll_number+ "\tName: " +name+ "\tpercentage: " +percentage);
    }

    public static void sortStudent(student[] arr)
    {
        int n = arr.length;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n-i-1; j++)
            {
                if(arr[j].percentage < arr[j+1].percentage)
                {
                    student temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}

public class Student_Sort
{
    public static void main(String[] args)throws IOException
    {
        //Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter number of objects: ");
        //int n = sc.nextInt();
        int n = Integer.parseInt(br.readLine());

        student arr[] = new student[n];

        for(int i=0; i<n; i++)
        {
            System.out.print("\n\nEnter roll number: ");
            //int roll_number = sc.nextInt();
            int roll_number = Integer.parseInt(br.readLine());

            System.out.print("Enter name: ");
            //String name = sc.next();
            String name = br.readLine();

            System.out.print("Enter percentage: ");
            //float percentage = sc.nextFloat();
            float percentage = Float.parseFloat(br.readLine());

            arr[i] = new student(roll_number, name, percentage);
        }

        student.sortStudent(arr);

        System.out.println("\nDeatails of student sorted by percentage: ");
        for(int i=0; i<arr.length; i++)
        {
            arr[i].display();
        }
    }
}
