import java.util.*;

public class Main
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int minPacked = Integer.MAX_VALUE;
        int minSingle = Integer.MAX_VALUE;
        
        for(int i = 0; i < M; i++)
        {
            int p = sc.nextInt();
            int s = sc.nextInt();

            if(p < minPacked) minPacked = p;
            if(s < minSingle) minSingle = s;
        }

        if (minPacked > 6 * minSingle) minPacked = 6 * minSingle;

        int onlySingle = N * minSingle;
        int onlyPacked = ((N + 5) / 6) * minPacked;
        int mixed = (N / 6) * minPacked + (N % 6) * minSingle;

        int ans = Math.min(onlySingle, Math.min(mixed, onlyPacked));
        System.out.println(ans);
        sc.close();
    }
}