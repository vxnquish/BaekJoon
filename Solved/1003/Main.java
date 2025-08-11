import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] zero = new int[41];
        int[] one = new int[41];

        zero[0] = 1; one[0] = 0;
        zero[1] = 0; one[1] = 1;

        for(int i = 2; i <= 40; i++)
        {
            zero[i] = zero[i - 1] + zero[i - 2];
            one[i]  = one[i - 1]  + one[i - 2];
        }

        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < T; t++)
        {
            int n = sc.nextInt();
            sb.append(zero[n]).append(' ').append(one[n]);
            if (t + 1 < T) sb.append('\n');
        }

        System.out.print(sb.toString());
        sc.close();
    }
}