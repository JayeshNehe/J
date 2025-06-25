import NumOperation.*;
import java.util.*;

public class number
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        prime p = new prime();
        p.checkPrime(num);

        perfect p1 = new perfect();
        p1.checkPerfect(num);

        armStrong a = new armStrong();
        a.checkArmStrong(num);
    }    
}
