import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] board = new char[N][M];

        for(int i = 0; i < N; i++)
        {
            String line = sc.next();
            for(int j = 0; j < M; j++)
            {
                board[i][j] = line.charAt(j);
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int i = 0; i <= N - 8; i++)
        {
            for(int j = 0; j <= M - 8; j++)
            {
                int count1 = 0;
                int count2 = 0;

                for(int x = 0; x < 8; x++)
                {
                    for(int y = 0; y < 8; y++)
                    {
                        char c = board[i + x][j + y];

                        if((x + y) % 2 == 0)
                        {
                            if(c != 'W') count1++;
                            if(c != 'B') count2++;
                        }

                        else
                        {
                            if(c != 'B') count1++;
                            if(c != 'W') count2++;
                        }
                    }
                }
                int need = Math.min(count1, count2);
                if(need < answer) answer = need;
            }
        }

        System.out.println(answer);
        sc.close();
    }
}