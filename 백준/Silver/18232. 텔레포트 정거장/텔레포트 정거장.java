
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N,M;
    public static int[] visited;
    public static List<Integer>[] adj;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        visited = new int[N+1];
        adj = new List[N+1];
        for(int i=0;i<=N;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st =  new StringTokenizer(in.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adj[A].add(B);
            adj[B].add(A);
        }





        visited[start] = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start,0});

        while(!q.isEmpty()){
            int[] curr = q.poll();

            if(curr[0] == end){
                System.out.println(curr[1]);
                return;
            }

            int next = curr[0] - 1;
            if(canGo(next)){
                visited[next] = 1;
                q.add(new int[]{next,curr[1] + 1});
            }

            next = curr[0]  + 1;
            if(canGo(next)){
                visited[next ] = 1;
                q.add(new int[] {next,curr[1]+1});
            }

            for(int pos : adj[curr[0]]){
                if(canGo(pos)){
                    visited[pos] = 1;
                    q.add(new int[]{pos, curr[1]+1});
                }
            }
        }
    }


    public static boolean canGo(int next){
        if(next <= 0 || next > N || visited[next] == 1){
            return false;
        }
        return true;
    }



}