import java.util.*;

public class Main
{
    static boolean inside(long x, long y, long cx, long cy, long r)
    {
        long dx = x - cx, dy = y - cy;
        return dx * dx + dy * dy < r * r;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while(T-- > 0)
        {
            long x1 = sc.nextLong();
            long y1 = sc.nextLong();
            long x2 = sc.nextLong();
            long y2 = sc.nextLong();
            int n = sc.nextInt();
            int count = 0;

            for(int i = 0; i < n; i++)
            {
                long cx = sc.nextLong();
                long cy = sc.nextLong();
                long r  = sc.nextLong();
                boolean a = inside(x1, y1, cx, cy, r);
                boolean b = inside(x2, y2, cx, cy, r);

                if(a ^ b) count ++;
            }

            System.out.println(count);
        }

        sc.close();
    }
}