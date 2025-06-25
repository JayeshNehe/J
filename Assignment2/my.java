import MScCAI.*;
import MScCAII.*;
import java.util.*;

class student
{
    String name;
    int rollNo;
    int Sem1, Sem2, sem1, sem2;
    int total;
    MScCAIMarks m1;
    MScCAIIMarks m2;

    student(String name, int rollNo, MScCAIMarks m1, MScCAIIMarks m2)
    {
        this.name = name;
        this.rollNo = rollNo;
        this.m1 = m1;
        this.m2 = m2;
    }

    public char calGrade(int total)
    {
        total = total/4;
        if(m1.SemITotal>40 && m1.SemIITotal>40 && m2.SemITotal>40 && m2.SemIITotal>40)
        {
            if (total >= 70) {
                return 'A';
            } else if (total >= 60) {
                return 'B';
            } else if (total >= 50) {
                return 'C';
            } else {
                return 'P'; // Pass class
            }
        }
        else {
            return 'F'; // Fail
        }
    }

    public void display()
    {
        System.out.println("Name of student: " +name);
        System.out.println("Roll No of student: " +rollNo);
        int total = m1.SemITotal + m1.SemIITotal + m2.SemITotal + m2.SemIITotal;
        System.out.println("Total Marks of student: " +total);
        System.out.println("Grade of student: " + calGrade(total));
    }
}

public class my {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MScCAIMarks m1;
        MScCAIIMarks m2;

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        student s[] = new student[n];

        for(int i=0; i<n; i++)
        {
            System.out.print("Enter name of student: ");
            String name = sc.next();

            System.out.print("Enter roll no of student: ");
            int rollNo = sc.nextInt();

            System.out.print("Enter sem I marks of MScCAI: ");
            int Sem1 = sc.nextInt();

            System.out.print("Enter sem II marks of MScCAI: ");
            int Sem2 = sc.nextInt();

            System.out.print("Enter sem I marks of MScCAII: ");
            int sem1 = sc.nextInt();

            System.out.print("Enter sem II marks of MScCAII: ");
            int sem2 = sc.nextInt();

            m1 = new MScCAIMarks(Sem1, Sem2);
            m2 = new MScCAIIMarks(sem1, sem2);

            s[i] = new student(name, rollNo, m1, m2);
        }

        System.out.println("Student details: ");
        for(int i=0; i<n; i++)
        {
            s[i].display();
        }
    }
}