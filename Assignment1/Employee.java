//import java.util.*;

class emp
{
    String name, position;
    float salary;
    public static int cnt;
    // static int cnt;

    emp()
    {
        cnt++;
    }

    emp(String name, String position, float salary)
    {
        this.name = name;
        this.position = position;
        this.salary = salary;
        cnt++;
    }

    static int getCount()
    {
        return cnt;
    }
    
    public String toString()
    {
        return "Name: " +name+ "\t" + "Position: " +position+ "\t" + "Salary: " +salary;
    }
}

public class Employee {
    public static void main(String[] args)
    {
        emp e1 = new emp("Chetan", "Developer", 10000);
        emp e2 = new emp("Shubham", "Manager", 80000);
        emp e3 = new emp();

        // System.out.println("Count of objects: " +emp.cnt);
        System.out.println("Count of objects: " +emp.getCount());
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
    }
}
