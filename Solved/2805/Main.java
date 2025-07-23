import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 나무의 개수
        long M = sc.nextLong(); // 가져가려고 하는 최소 나무 길이 합

        int[] tree = new int[N];
        int max = 0; // 나무 높이의 최댓값을 기록할 변수

        // 1) 모든 나무 높이를 읽어들이고, 최댓값을 찾아낸다.
        for (int i = 0; i < N; i++) {
            tree[i] = sc.nextInt();
            if (tree[i] > max) {
                max = tree[i];
            }
        }

        long low = 0, // 이분 탐색 하한 (톱날 높이의 최소)
                high = max, // 이분 탐색 상한 (톱날 높이의 최대)
                ans = 0; // M 이상의 나무를 얻을 수 있는 최대 톱날 높이

        // 2) 톱날 높이(mid)를 이분 탐색으로 결정
        while (low <= high) {
            long mid = (low + high) / 2; // 시도해볼 톱날 높이
            long sum = 0; // mid 높이로 벤 뒤 얻어지는 나무 길이 합

            // 3) 각 나무마다 mid 위를 자르고 남은 길이를 sum에 더한다
            for (int x : tree) {
                if (x > mid) {
                    sum += x - mid;
                }
            }

            // 4) 얻어지는 나무 길이가 목표 M 이상이면
            if (sum >= M) {
                ans = mid; // mid는 유효한 답안이므로 ans에 저장
                low = mid + 1; // 더 높은 톱날 높이를 시도해본다
            } else {
                high = mid - 1; // M을 채우지 못하므로 톱날을 낮춰본다
            }
        }

        // 5) 최종적으로 ans에 남아 있는 값이 정답
        System.out.println(ans);
    }
}
