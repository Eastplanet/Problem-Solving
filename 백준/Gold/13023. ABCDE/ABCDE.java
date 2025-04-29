
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N,M;
    public static List<Integer>[] adj;
    public static int[] visited;

    public static void main(String[] args) throws Exception {

        int max = 0;

        init();

        for(int i=0;i<N;i++){
            visited = new int[N];
            visited[i] = 1;
            boolean isExist = DFS(i, 0);

            if(isExist){
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }

    public static boolean DFS(int num,int dept){

        if(dept == 4){
            return true;
        }

        boolean result = false;

        for(int next : adj[num]){
            if(visited[next] == 1){
                continue;
            }

            visited[next] = 1;
            result = result | DFS(next, dept+1);
            visited[next] = 0;
        }

        return result;
    }
    public static void init() throws Exception{
        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new List[N];
        for(int i=0;i<N;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
    }



}