import java.util.*;

public class Main
{
    static int M, N, K;
    static boolean[][] a, v;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    static void dfs(int y, int x)
    {
        v[y][x] = true;
        for(int d = 0; d < 4; d++)
        {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
            if (a[ny][nx] && !v[ny][nx]) dfs(ny, nx);
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0)
        {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();
            a = new boolean[N][M];
            v = new boolean[N][M];

            for(int i = 0; i < K; i++)
            {
                int x = sc.nextInt();
                int y = sc.nextInt();
                a[y][x] = true;
            }

            int count = 0;
            for(int y = 0; y < N; y++)
            {
                for(int x = 0; x < M; x++)
                {
                    if (a[y][x] && !v[y][x])
                    {
                        dfs(y, x); count++;
                    }
                }
            }

            System.out.println(count);
        }
        sc.close();
    }
}
