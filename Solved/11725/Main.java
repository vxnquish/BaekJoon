import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // number of nodes
        List<Integer>[] adj = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) 
        {
            adj[i] = new ArrayList<>();
        }

        // connecting u-v
        for(int i = 0; i < N - 1; i++)
        {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj[u].add(v);
            adj[v].add(u);
        }

        int[] parent = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        // BFS to find the parent of each node
        Queue<Integer> queue = new LinkedList<>();
        visited[1] = true; 
        queue.add(1);

        while(!queue.isEmpty())
        {
            int u = queue.poll(); // take out of the queue

            for(int v : adj[u]) // for all v connected to u
            {
                if(!visited[v]) // if v is not visited
                {
                    visited[v] = true; // mark v as visited
                    parent[v] = u; // set parent of v as u
                    queue.add(v); // add v to the queue
                }
            }
        }

        // Output the parent of each node
        for(int i = 2; i <= N; i++)
        {
            System.out.println(parent[i]);
        }
    }
}