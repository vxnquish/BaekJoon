import java.util.*;

public class Main {
    static int k;
    static int[] s = new int[13];
    static int[] c = new int[6];
    static boolean first = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            k = sc.nextInt();
            if (k == 0) {
                break;
            }
            if (!first) {
                System.out.println();
            }
            first = false;
            for (int i = 0; i < k; i++) {
                s[i] = sc.nextInt();
            }
            dfs(0, 0);
        }
    }

    static void dfs(int i, int j) {
        if (i == 6) {
            for (int x = 0; x < 6; x++) {
                System.out.print(c[x] + (x < 5 ? " " : ""));
            }
            System.out.println();
            return;
        }
        for (int t = j; t < k; t++) {
            c[i] = s[t];
            dfs(i + 1, t + 1);
        }
    }
}
