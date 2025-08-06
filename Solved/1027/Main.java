import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] h = new long[N]; // int로 하면 오답이라 뜸

        for(int i = 0; i < N; i++)
        {
            h[i] = sc.nextInt();
        }

        int[] cnt = new int[N];

        for(int i = 0; i < N; i++)
        {
            for(int j = i + 1; j < N; j++)
            {
                boolean visible = true;

                for(int k = i + 1; k < j; k++)
                {
                    if((h[j] - h[i]) * (k - i) <= (h[k] - h[i]) * (j - i))
                    {
                        visible = false;
                        break;
                    }
                }

                if(visible)
                {
                    cnt[i]++;
                    cnt[j]++;
                }
            }
        }

        int answer = 0;
        for(int x : cnt)
        {
            if(x > answer) answer = x;
        }

        System.out.println(answer);
    }
}