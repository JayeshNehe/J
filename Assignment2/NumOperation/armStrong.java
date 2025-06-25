package NumOperation;

public class armStrong
{
    public void checkArmStrong(int num)
    {
        int rem;
        int n = num;
        int sum = 0;

        if(num >= 100)
        {
            while(num > 0)
            {
                rem = num%10;
                num = num/10;
                sum += rem * rem * rem;
            }
        }
        else if(num >= 10)
        {
            while(num > 0)
            {
                rem = num%10;
                num = num/10;
                sum += rem * rem;
            }
        }
        else if(num < 10)
        {
            sum += num;
        }

        if(sum == n)
            System.out.println(n+ " is a Arm Strong Number");
        else
            System.out.println(n+ " is not a Arm Strong Number");
    }
}
