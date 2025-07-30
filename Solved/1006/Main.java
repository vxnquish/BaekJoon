import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 개수

        while(T-- > 0)
        {
            // // //

            int N = sc.nextInt(); // 구역의 개수/2
            int W = sc.nextInt(); // 특수 소대원의 수

            // 적의 수
            int[][] enemy = new int[2][N];

            for(int i = 0; i < 2; i++)
            {
                for(int j = 0; j < N; j++)
                {
                    enemy[i][j] = sc.nextInt();
                }
            }

            // 특수 case (N = 1일 때)
            if(N == 1)
            {
                System.out.println(enemy[0][0] + enemy[1][0] <= W ? 1 : 2);
                // 두 칸 합이 W 이하: 1명, 초과: 2명
                continue;
            }

            int answer = 2 * N; // 최악의 경우로 초기화

            for(int init = 0; init < 4; init++)
            {
                if ((init & 1) != 0 && enemy[0][0] + enemy[0][N - 1] > W) continue;
                if ((init & 2) != 0 && enemy[1][0] + enemy[1][N - 1] > W) continue;

                int[] dp = new int[4];
                Arrays.fill(dp, -1);
                dp[init] = 0;

                for(int i = 0; i < N; i++)
                {
                    int ni = (i + 1) % N;
                    boolean canVertical =  (enemy[0][i] + enemy[1][i] <= W);

                    int[] next = new int[4];
                    Arrays.fill(next, -1);

                    for(int mask = 0; mask < 4; mask++)
                    {
                        if(dp[mask] < 0) continue;

                        for(int nm = 0; nm < 4; nm++)
                        {
                            if ((mask & nm) != 0) continue;
                            if ((nm & 1) != 0 && enemy[0][i] + enemy[0][ni] > W) continue;
                            if ((nm & 2) != 0 && enemy[1][i] + enemy[1][ni] > W) continue;

                            int val = dp[mask] + Integer.bitCount(nm);
                            next[nm] = Math.max(next[nm], val);

                            if(mask == 0 && nm == 0 && canVertical)
                            {
                                next[0] = Math.max(next[0], dp[mask] + 1);
                            }
                        }
                    }

                    dp = next;
                }

                if(dp[init] >= 0)
                {
                    int used = 2 * N - dp[init];
                    answer = Math.min(answer, used);
                }
            }

            System.out.println(answer);

            // // //
        }
    }
}