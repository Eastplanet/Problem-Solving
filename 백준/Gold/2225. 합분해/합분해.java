import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static int N, K;
    public static final int DIVIDE_NUM = 1_000_000_000;
    public static int[][] dp;

    public static void main(String[] args) throws Exception{

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[K+1][N+1];

        for(int i=0;i<=N;i++){
            dp[1][i] = 1;
        }

        for(int i=2;i<=K;i++){
            for(int j=0;j<=N;j++){
                for(int k=0;k<=j;k++){
                    dp[i][j] = ((dp[i][j] % DIVIDE_NUM) + (dp[i-1][k] % DIVIDE_NUM)) % DIVIDE_NUM;
                }
            }
        }

        System.out.println(dp[K][N]);
    }
}