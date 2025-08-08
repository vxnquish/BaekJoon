import java.util.*;

public class Main
{
    static class P
    {
        int v, i;
        P(int v, int i)
        {
            this.v = v;
            this.i = i;
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        P[] a = new P[N];

        for(int i = 0; i < N; i++)
        {
            a[i] = new P(sc.nextInt(), i);
        }

        Arrays.sort(a, (x, y) -> x.v != y.v ? x.v - y.v : x.i - y.i);

        int[] P = new int[N];
        for(int rank = 0; rank < N; rank++)
        {
            P[a[rank].i] = rank;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++)
        {
            if(i > 0) sb.append(" ");
            sb.append(P[i]);
        }

        System.out.println(sb.toString());
        sc.close();
    }
}