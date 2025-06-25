//import java.util.*;
package NumOperation;

public class perfect
{
    public void checkPerfect(int num)
    {
        int sum = 1;
        for(int i=1; i<=num/2; i++)
        {
            if(num%i == 0)
            {
                sum = sum * i;
            }
        }

        if(sum == num)
            System.out.println(num+ " is a perfect Number");
        else
            System.out.println(num+ " is not a perfect Number");
    }
}