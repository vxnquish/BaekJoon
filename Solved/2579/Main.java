import java.util.*;

public class Main
{
    public static void main(String[] args) 
    {  
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // number of stairs
        int[] cost = new int[n + 1];

        for(int i = 1; i <= n; i++)
        {
            cost[i] = sc.nextInt();
        }
            
        int[] dp = new int[n + 1];

        if(n >= 1) dp[1] = cost[1];
        if(n >= 2) dp[2] = cost[1] + cost[2];

        for(int i = 3; i <= n; i++)
        {
            dp[i] = Math.max( dp[i - 2] + cost[i], dp[i - 3] + cost[i - 1] + cost[i] );
        }

        System.out.println(dp[n]);
    }
}
