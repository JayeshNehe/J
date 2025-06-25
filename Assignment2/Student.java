import MScCAI.*;
import MScCAII.*;
import java.util.*;

public class Student
{
    int rollNo;
    String name;
    MScCAIMarks m1;
    MScCAIIMarks m2;

    Student(int rollNo, String name, MScCAIMarks m1, MScCAIIMarks m2)
    {
        this.rollNo = rollNo;
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
    }

    public void display()
    {
        System.out.println("Name of student: " +name);
        System.out.println("Roll No of student: " +rollNo);
        int total = m1.SemITotal + m1.SemIITotal + m2.SemITotal + m2.SemIITotal;
        System.out.println("Total Marks of student: " +total);
        System.out.println("Grade of student: " + calGrade(total));
    }

    public char calGrade(int total)
    {
        total = total/4;
        if(m1.SemITotal>=40 && m1.SemIITotal>=40 && m2.SemITotal>=40 && m2.SemIITotal>=40)
        {
            if(total >= 70)
            {
                return 'A';
            }
            else if(total >= 60)
            {
                return 'B';
            }
            else if(total >= 50)
            {
                return 'C';
            }
            else
            {
                return 'P'; // Pass class
            }
        }
        else
        {
            return 'F'; // Fail
        }
        //return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Student s[] = new Student[n];
        for(int i=0; i<n; i++)
        {
            System.out.print("\nEnter name of student: ");
            String name = sc.next();

            System.out.print("Enter roll no of student: ");
            int rollNo = sc.nextInt();

            System.out.print("\nEnter sem I marks of MScCAI: ");
            int Sem1 = sc.nextInt();

            System.out.print("Enter sem II marks of MScCAI: ");
            int Sem2 = sc.nextInt();

            System.out.print("\nEnter sem I marks of MScCAII: ");
            int sem1 = sc.nextInt();

            System.out.print("Enter sem II marks of MScCAII: ");
            int sem2 = sc.nextInt();

            MScCAIMarks m1 = new MScCAIMarks(Sem1, Sem2);
            MScCAIIMarks m2 = new MScCAIIMarks(sem1, sem2);

            s[i] = new Student(rollNo, name, m1, m2);
        }

        for(int i=0; i<n; i++)
        {
            s[i].display();
        }
    }
}