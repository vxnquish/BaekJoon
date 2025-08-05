import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        boolean[] isPrime = barray(2000);

        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int v : arr) {
            if (v % 2 == 0) even.add(v);
            else           odd.add(v);
        }

        List<Integer> A, B;
        if (arr[0] % 2 == 0) {
            A = even;  B = odd;
        } else {
            A = odd;   B = even;
        }

        if (A.size() != B.size()) {
            System.out.println(-1);
            return;
        }

        int n = A.size();
        boolean[][] graph = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = isPrime[A.get(i) + B.get(j)];
            }
        }

        int start = A.indexOf(arr[0]);
        List<Integer> answer = new ArrayList<>();

        for (int j = 0; j < n; j++) {
            if (!graph[start][j]) continue;
            int[] match = new int[n];
            Arrays.fill(match, -1);
            match[j] = start;
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                if (i == start) continue;
                if (!augment(i, graph, match, new boolean[n], j)) {
                    ok = false;
                    break;
                }
            }
            if (ok) answer.add(B.get(j));
        }

        if (answer.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(answer);
            for (int i = 0; i < answer.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(answer.get(i));
            }
            System.out.println();
        }
    }

    static boolean augment(int u, boolean[][] graph, int[] match, boolean[] seen, int skip) {
        for (int v = 0; v < graph.length; v++) {
            if (v == skip || seen[v] || !graph[u][v]) continue;
            seen[v] = true;
            if (match[v] == -1 || augment(match[v], graph, match, seen, skip)) {
                match[v] = u;
                return true;
            }
        }
        return false;
    }

    static boolean[] barray(int m) {
        boolean[] prime = new boolean[m + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i * i <= m; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= m; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }
}
