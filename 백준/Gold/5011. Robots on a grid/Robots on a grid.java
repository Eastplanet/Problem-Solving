
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N;
    public static char[][] arr;
    public static long[][] dp;

    public static long MODULO = (1<<31) - 1;

    public static void main(String[] args) throws Exception {
        init();



        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){

                if(i == 1 && j == 1){
                    dp[i][j] = 1;
                    continue;
                }

                if(arr[i][j] == '.'){
                    dp[i][j] = (dp[i-1][j]%MODULO + dp[i][j-1]%MODULO)%MODULO;
                }

            }
        }

        if(dp[N][N] != 0){
            System.out.println(dp[N][N]);
            return;
        }

        Queue<int[]> q = new ArrayDeque<>();
        int[][] visited = new int[N+1][N+1];

        q.add(new int[]{1,1});
        visited[1][1] = 1;

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        while(!q.isEmpty()){
            int[] curr = q.poll();

            if(curr[0] == N && curr[1] == N){
                System.out.println("THE GAME IS A LIE");
                return;
            }

            for(int i=0;i<4;i++){
                int gox = curr[1] + dx[i];
                int goy = curr[0] + dy[i];

                if(gox <= 0 || gox > N || goy <= 0 || goy > N || visited[goy][gox] == 1 || arr[goy][gox] == '#'){
                    continue;
                }

                visited[goy][gox] = 1;
                q.add(new int[]{goy,gox});
            }


        }


        System.out.println("INCONCEIVABLE");
    }

    public static void init() throws Exception {
        N = Integer.parseInt(in.readLine());

        arr = new char[N+1][N+1];
        dp = new long[N+1][N+1];

        for(int i=1;i<=N;i++){
            String tmp = in.readLine();
            for(int j=1;j<=N;j++){
                arr[i][j] = tmp.charAt(j-1);
            }
        }
    }


}