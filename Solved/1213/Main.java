import java.util.*;

public class Main
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] count = new int[26]; 
        
        for(char c : s.toCharArray()) count[c - 'A']++;

        int odd = 0; char mid = 0;

        for(int i = 0; i < 26; i++)
        {
            if((count[i] & 1) == 1)
            {
                odd++;
                mid = (char)('A' + i);
            }
        }

        if(odd > 1)
        {
            System.out.println("I'm Sorry Hansoo"); 
            return;
        }

        StringBuilder left = new StringBuilder();

        for(int i = 0; i < 26; i++)
        {
            for(int k = 0; k < count[i] / 2; k++)
            {
                left.append((char)('A' + i));
            }
        }

        StringBuilder ans = new StringBuilder();

        ans.append(left);

        if(odd == 1)
        {
            ans.append(mid);
        }

        ans.append(new StringBuilder(left).reverse());

        System.out.println(ans.toString());

        sc.close();
    }
}