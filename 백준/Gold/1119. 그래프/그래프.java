
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N, preparationEdges, clusterCnt;
    public static int[][] arr;
    public static int[] visited;
    public static boolean absoluteFail;

    public static void main(String[] args) throws Exception {

        init();

        for(int i=1;i<=N;i++){
            if(visited[i] == 0){
                clusterCnt++;
                int preparationEdge = BFS(i);
                preparationEdges += preparationEdge;
            }
        }

        if(absoluteFail && N != 1){
            System.out.println(-1);
            return;
        }

        int needChangeEdgeCnt = clusterCnt-1;
        if(preparationEdges >= needChangeEdgeCnt){
            System.out.println(needChangeEdgeCnt);
        }
        else{
            System.out.println(-1);
        }

    }

    public static int BFS(int start){

        int nodeCnt = 0;
        int edgeCnt = 0;

        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = 1;
        q.add(start);

        while(!q.isEmpty()){

            int curr = q.poll();
            nodeCnt++;

            for(int next=1;next<=N;next++){
                if(arr[curr][next] == 1 && curr < next){
                    edgeCnt++;
                }
                if(arr[curr][next] == 0 || visited[next] == 1){
                    continue;
                }
                visited[next] = 1;
                q.add(next);
            }
        }

        if(nodeCnt == 1){
            absoluteFail = true;
        }

        if(edgeCnt < nodeCnt){
            return 0;
        }
        else {
            return edgeCnt - (nodeCnt-1);
        }
    }

    public static void init() throws Exception{
        N = Integer.parseInt(in.readLine());

        visited = new int[N+1];
        arr = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            String tmp =  in.readLine();
            for(int j=1;j<=N;j++){
                if(tmp.charAt(j-1) == 'Y'){
                    arr[i][j] = 1;
                }
                else{
                    arr[i][j] = 0;
                }
            }
        }
    }



}