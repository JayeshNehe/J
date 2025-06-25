

class MyNumber
{
    private int num;

    MyNumber()
    {
        num = 0;
    }

    MyNumber(int number)
    {
        this.num = number;
    }

    public boolean isNegative() {
        return num < 0; 
    }

    public boolean isPositive() {
        return num > 0;
    }

    public boolean isZero() {
        return num == 0;
    }

    public boolean isEven() {
        return num % 2 == 0;
    }

    public boolean isOdd() {
        return num % 2 != 0;
    }

    // void check()
    // {
    //     if(num>0)
    //     {
    //         System.out.println("Number " +num+ " is Positive");
    //         if(num%2 == 0)
    //         {
    //             System.out.println("Number " +num+ " is Even");
    //         }
    //         else if(num%2 != 0)
    //         {
    //             System.out.println("Number " +num+ " is Odd");
    //         }
    //     }
    //     else if(num<0)
    //     {
    //         System.out.println("Number " +num+ " is Negative");
    //         if(num%2 == 0)
    //         {
    //             System.out.println("Number " +num+ " is Even");
    //         }
    //         else if(num%2 != 0)
    //         {
    //             System.out.println("Number " +num+ " is Odd");
    //         }
    //     }
    //     else if(num==0)
    //     {
    //         System.out.println("Number " +num+ " is Zero");
    //     }
    // }
}

public class Number {
    public static void main(String[] args) {
        MyNumber n1 = new MyNumber(Integer.parseInt(args[0]));
        //n1.check();

        System.out.println("Is Negative: " + n1.isNegative());
        System.out.println("Is Positive: " + n1.isPositive());
        System.out.println("Is Zero: " + n1.isZero());
        System.out.println("Is Even: " + n1.isEven());
        System.out.println("Is Odd: " + n1.isOdd());

        // if(n1.isPositive())
        // {
        //     System.out.println("Number " +n1+ " is Positive");
        // }
    }
}
