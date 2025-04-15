
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N,M;
    public static int[] dist, weather;
    public static int[][] dp;

    public static void main(String[] args) throws Exception {
        init();

        dp[0][0] = 0;

        for(int i=1;i<=M;i++) {
            for(int j=0;j<=N;j++){

                dp[i][j] = dp[i-1][j];

                if(j-1 >= 0){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + dist[j]*weather[i]);
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i=0;i<=M;i++){
            min = Math.min(min, dp[i][N]);
        }

        System.out.println(min);

    }

    public static void init() throws Exception {

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        weather = new int[M+1];
        dp = new int[M+1][N+1];

        for(int i=0;i<M+1;i++){
            for(int j=0;j<N+1;j++){
                dp[i][j] = 2_000_000_000;
            }
        }

        for(int i=1;i<=N;i++){
            dist[i] = Integer.parseInt(in.readLine());
        }

        for(int i=1;i<=M;i++){
            weather[i] = Integer.parseInt(in.readLine());
        }


    }


}