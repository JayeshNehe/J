//import java.util.*;
package NumOperation;

public class prime
{
    public void checkPrime(int num)
    {
        int flag = 0;
        for(int i=2; i<=num/2; i++)
        {
            if(num%i == 0)
                flag = 1;
        }

        if(flag == 0)
            System.out.println(num+ " is a prime Number");
        else
            System.out.println(num+ " is not a prime Number");
    }
}