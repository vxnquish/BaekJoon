import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        int L = sc.nextInt();
        boolean found = false;

        for(int i = L; i < 101; i++)
        {
            long t = N - (long)i * (i - 1) / 2;

            if(t < 0) break;
            if(t % i == 0)
            {
                long x = t / i;

                if(x >= 0)
                {
                    for(int j = 0; j < i; j++)
                    {
                        System.out.print(x + j);
                        if(j < i - 1) System.out.print(" ");
                    }
                    System.out.println();
                    found = true;
                    break;
                }
            }
        }
        if(!found)
        {
            System.out.println(-1);
        }
        sc.close();
    }
}