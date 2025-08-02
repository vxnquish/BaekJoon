import java.util.*;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] cnt = new int[1002];

        for (int i = 0; i < N; i++)
            cnt[sc.nextInt()]++;

        List<Integer> res = new ArrayList<>();
        int remain = N;

        while (remain > 0)
        {
            int x = 0;
            while (cnt[x] == 0) x++;

            if (x + 1 < cnt.length && cnt[x + 1] > 0) 
            {
                int y = -1;
                for (int j = x + 2; j < cnt.length; j++) 
                {
                    if (cnt[j] > 0) 
                    {
                        y = j;
                        break;
                    }
                }

                if (y != -1) 
                {
                    int cx = cnt[x];
                    for (int k = 0; k < cx; k++) res.add(x);
                    cnt[x] = 0;
                    remain -= cx;
                    res.add(y);
                    cnt[y]--;
                    remain--;
                } 

                else
                {
                    int c1 = cnt[x + 1];
                    for (int k = 0; k < c1; k++) res.add(x + 1);
                    cnt[x + 1] = 0;
                    remain -= c1;
                    int cx = cnt[x];

                    for (int k = 0; k < cx; k++) res.add(x);
                    cnt[x] = 0;
                    remain -= cx;
                }
            } 
            
            else 
            {
                int cx = cnt[x];
                for (int k = 0; k < cx; k++) res.add(x);
                cnt[x] = 0;
                remain -= cx;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.size(); i++)
        {
            if (i > 0) sb.append(' ');
            sb.append(res.get(i));
        }
        
        System.out.println(sb);
        sc.close();
    }
}
