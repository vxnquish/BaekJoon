import java.util.*;

public class Main
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder ans = new StringBuilder();
        
        while(sc.hasNextInt())
        {
            int n = sc.nextInt();
            if(n == 0) break;

            long[] h = new long[n + 1];

            for(int i = 0; i < n; i++)
                h[i] = sc.nextLong();
            h[n] = 0;

            int[] stack = new int[n + 1];
            int top = -1;
            long best = 0;

            for(int i = 0; i <= n; i++)
            {
                while(top >= 0 && h[stack[top]] > h[i])
                {
                    long height = h[stack[top--]];
                    int left = (top < 0) ? -1 : stack[top];
                    int width = i - left - 1;
                    long area = height * width;
                    if(area > best) best = area;
                }

                stack[++top] = i;
            }

            ans.append(best).append('\n');
        }

        System.out.println(ans.toString());
        sc.close();
    }
}