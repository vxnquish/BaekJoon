import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int r = powMod(a, b, 10);

            if(r == 0) r = 10;
            System.out.println(r);
        }

        sc.close();
    }

    static int powMod(int a, int b, int m)
    {
        int result = 1;
        a %= m;

        while(b > 0)
        {
            if((b & 1) == 1)
            {
                result = (result * a) % m;
            }

            a = (a * a) % m;
            b >>= 1;
        }

        return result;
    }
}