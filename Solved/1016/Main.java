import java.util.*;

public class Main 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        int size = (int) (max - min + 1); // Number of integers in the range [min, max]
        boolean[] ok = new boolean[size]; // Initially assume all numbers are valid
        
        Arrays.fill(ok, true);

        for(long i = 2; i * i <= max; i++) // int i : Runtime Error
        {
            long sq = i * i; // Square of the current number
            long start = ((min + sq - 1) / sq) * sq; // Find the first multiple of sq that is >= min

            for(long j = start; j <= max; j += sq)
            {
                ok[(int) (j - min)] = false; // Mark multiples of the square as invalid
            }
        }

        int count = 0;
        for(boolean b : ok)
        {
            if(b) count++;
        }

        System.out.println(count);
    }
}