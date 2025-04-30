
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N;
    public static int[] visited,select;
    public static List<Integer>[] adj;

    public static void main(String[] args) throws Exception {

        init();

        for(int i=1;i<=N;i++){
            visited[i] = 1;
            DFS(i,i);
            visited[i] = 0;
        }

        int cnt = 0;
        for(int i=1;i<=N;i++){
            if(select[i] == 1){
                cnt++;
            }
        }

        System.out.println(cnt);
        for(int i=1;i<=N;i++){
            if(select[i] == 1){
                System.out.println(i);
            }
        }
    }

    public static void DFS(int start, int curr){

        for(int next : adj[curr]){
            if(next == start){
                markCurrentState();
            }
            if(visited[next] == 1){
                continue;
            }

            visited[next] = 1;
            DFS(start, next);
            visited[next] = 0;
        }

    }

    public static void markCurrentState(){

        for(int i=1;i<=N;i++){
            if(visited[i] == 1){
                select[i] = 1;
            }
        }
    }



    public static void init() throws Exception{
        N = Integer.parseInt(in.readLine());
        visited = new int[N+1];
        select = new int[N+1];

        adj = new List[N+1];
        for(int i=1;i<=N;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=1;i<=N;i++){
            int num = Integer.parseInt(in.readLine());
            adj[i].add(num);
        }
    }



}