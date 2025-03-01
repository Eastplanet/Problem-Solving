import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static int N;
    public static int[] visited,dp;
    public static List<Integer>[] adj;
    public static int[] parent;
    public static int root;

    public static void main(String[] args) throws Exception{

        input();

        // root에서부터 리프 노드의 개수를 topDown식으로 센다.
        dp[root] = cntLeaf(root);

        int M = Integer.parseInt(in.readLine());

        // 자신의 부모가 leaf노드로 변한다.
        if(adj[parent[M]].size() == 1){
            System.out.println(dp[root] - dp[M] + 1);
        }
        else{
            System.out.println(dp[root] - dp[M]);
        }

    }

    public static int cntLeaf(int node){

        // 자신이 리프노드 인 경우
        if(adj[node].size() == 0){
            return dp[node] = 1;
        }

        int sum = 0;
        for(int child : adj[node]){
            sum += cntLeaf(child);
        }

        return dp[node] = sum;
    }

    public static void input() throws Exception{
        N = Integer.parseInt(in.readLine());

        visited = new int[N];
        dp = new int[N];
        adj = new ArrayList[N];
        for(int i=0;i<N;i++){
            adj[i] = new ArrayList<>();
        }

        parent = new int[N];

        st = new StringTokenizer(in.readLine());
        for(int i=0;i<N;i++){
            int next = Integer.parseInt(st.nextToken());
            if(next == -1){
                root = i;
                continue;
            }
            // 부모 -> 자식 방향으로 간선 연결
            adj[next].add(i);
            // i 의 부모는 next이다.
            parent[i] = next;
        }
    }

}