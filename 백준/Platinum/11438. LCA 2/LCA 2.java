
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N;
    public static List<Integer>[] adj;
    public static int[][] p;
    public static int[] HEIGHT;

    public static final int MAX_HEIGHT = 20;

    public static void main(String[] args) throws Exception {

        init();
        searchParent();
        makeParentArr();

        int M = Integer.parseInt(in.readLine());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(in.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            System.out.println(lca(A,B));
        }

    }

    public static int lca(int A,int B){
        if(HEIGHT[A] != HEIGHT[B]){
            if(HEIGHT[A] < HEIGHT[B]){
                int tmp = A;
                A = B;
                B = tmp;
            }

            int diff = HEIGHT[A] - HEIGHT[B];
            for(int i=0;diff > 0;i++){
                if(diff%2 == 1){
                    A = p[A][i];
                }
                diff = diff >> 1;
            }
        }

        if(A == B){
            return A;
        }

        for(int i=MAX_HEIGHT-1;i>= 0;i--){
            if(p[A][i] != p[B][i] && p[A][i] != 0){
                A = p[A][i];
                B = p[B][i];
            }
        }

        return p[A][0];
    }

    public static void searchParent(){
        int[] visited = new int[N+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = 1;
        HEIGHT[1] = 0;

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int next : adj[curr]){
                if(visited[next] == 1){
                    continue;
                }
                visited[next] = 1;
                q.add(next);
                p[next][0] = curr;
                HEIGHT[next] = HEIGHT[curr]+1;
            }
        }
    }

    public static void makeParentArr(){
        for(int i=1;i<MAX_HEIGHT;i++){
            for(int j=1;j<=N;j++){
                p[j][i] = p[ p[j][i-1] ][ i-1 ];
            }
        }
    }


    public static void init() throws Exception {
        N = Integer.parseInt(in.readLine());

        adj = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            adj[i] = new ArrayList<>();
        }

        HEIGHT = new int[N+1];
        p = new int[N+1][MAX_HEIGHT];

        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(in.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adj[A].add(B);
            adj[B].add(A);
        }
    }
}