import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N,Q;
    public static List<int[]>[] adj;



    public static void main(String[] args) throws Exception{

        input();

        for(int i=0;i<Q;i++){
            st = new StringTokenizer(in.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            System.out.println(BFS(k,v));
        }

    }

    public static int BFS(int k,int v){
        int result = 0;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{v,0});
        boolean[] visited = new boolean[N+1];

        visited[v] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            if(curr[1] >= k){
                result++;
            }

            for(int[] edge: adj[curr[0]]){
                int next = edge[0];
                int cost = edge[1];

                if(visited[next]){
                    continue;
                }

                visited[next] = true;

                int nextWeight;
                if(curr[1] == 0){
                    nextWeight = cost;
                }
                else{
                    nextWeight = Math.min(cost,curr[1]);
                }
                q.add(new int[]{next,Math.min(cost,nextWeight)});
            }
        }




        return result;
    }

    public static void input() throws Exception{
        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[s].add(new int[]{e,w});
            adj[e].add(new int[]{s,w});
        }

    }



}