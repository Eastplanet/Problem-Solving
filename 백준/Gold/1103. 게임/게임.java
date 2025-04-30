
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N,M;
    public static int[][] arr, visited, dp;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static boolean infiniteFlag;

    public static void main(String[] args) throws Exception {
        init();

        visited[0][0] = 1;
        int maxCnt = DFS(0,0);
        if(infiniteFlag){
            System.out.println(-1);
        }
        else{
            System.out.println(maxCnt);
        }
    }

    public static int DFS(int y,int x){

        if(infiniteFlag){
            return -1;
        }
        if(dp[y][x] != 0){
            return dp[y][x];
        }

        int cnt = 0;

        int num = arr[y][x];

        for(int i=0;i<4;i++){
            int gox = x + num*dx[i];
            int goy = y + num*dy[i];

            if(gox < 0 || gox >= M || goy < 0 || goy >= N || arr[goy][gox] == -1){
                continue;
            }
            if(visited[goy][gox] == 1){
                infiniteFlag = true;
                return cnt;
            }

            visited[goy][gox] = 1;
            cnt = Math.max(cnt, DFS(goy,gox));
            visited[goy][gox] = 0;
        }

        return dp[y][x] = cnt + 1;
    }

    public static void init() throws Exception{
        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new int[N][M];
        arr = new int[N][M];
        dp = new int[N][M];

        for(int i=0;i<N;i++){
            String tmp = in.readLine();
            for(int j=0;j<M;j++){
                if(tmp.charAt(j)=='H'){
                    arr[i][j] = -1;
                }
                else{
                    arr[i][j] = tmp.charAt(j)-'0';
                }
            }
        }
    }



}