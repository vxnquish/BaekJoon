import java.util.*;

public class Main
{
    static int[] left = new int[26];    // 왼쪽 자식 노드 인덱스 (알파벳 26개)
    static int[] right = new int[26];   // 오른쪽 자식 노드 인덱스

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 이진 트리의 노드 개수 1 <= N <= 26

        // 자식이 없음으로 초기화
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        for(int i = 0; i < N; i++)
        {
            char node =  sc.next().charAt(0); // 부모 노드
            char leftChild = sc.next().charAt(0); // 왼쪽 자식 노드
            char rightChild = sc.next().charAt(0); // 오른쪽 자식 노드

            int u = node - 'A'; // 부모 노드 인덱스

            if(leftChild != '.')
                left[u] = leftChild - 'A'; // 왼쪽 자식 노드 인덱스 

            if(rightChild != '.')
                right[u] = rightChild - 'A'; // 오른쪽 자식 노드 인덱스
        }

        // 전위 순회
        preorder(0);
        System.out.println();
        
        // 중위 순회
        inorder(0);
        System.out.println();

        // 후위 순회
        postorder(0);
    }

    static void preorder(int u) // 전위 순회 (루왼오)
    {
        if(u == -1) return;                 // 자식이 없으면 종료
        System.out.print((char)(u + 'A'));  // 현재 노드 출력 (루트)
        preorder(left[u]);                  // 왼쪽 자식 방문
        preorder(right[u]);                 // 오른쪽 자식 방문
    }

    static void inorder(int u) // 중위 순회 (왼루오)
    {
        if(u == -1) return;                 // 자식이 없으면 종료
        inorder(left[u]);                   // 왼쪽 자식 방문
        System.out.print((char)(u + 'A'));  // 현재 노드 출력 (루트)
        inorder(right[u]);                  // 오른쪽 자식 방문
    }

    static void postorder(int u) // 후위 순회 (왼오루)
    {
        if(u == -1) return;                 // 자식이 없으면 종료
        postorder(left[u]);                 // 왼쪽 자식 방문
        postorder(right[u]);                // 오른쪽 자식 방문
        System.out.print((char)(u + 'A'));  // 현재 노드 출력 (루트)
    }
}
