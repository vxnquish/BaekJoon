import java.util.*;

public class Main
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int[] a = new int[N];

        for (int i = 0; i < N; i++) 
        {
            a[i] = sc.nextInt();
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < N; i++)
        {
            // 더 큰 뒤쪽의 값들 삭제
            while(!deque.isEmpty() && a[deque.peekLast()] > a[i])
            {
                deque.pollLast();
            }
            deque.addLast(i);

            // 범위 벗어난 인덱스 삭제
            if(deque.peekFirst() <= i - L)
            {
                deque.pollFirst();
            }

            // 최소값 출력
            System.out.print(a[deque.peekFirst()]);
            if (i < N - 1) 
            {
                System.out.print(" ");
            }
        }
    }
}