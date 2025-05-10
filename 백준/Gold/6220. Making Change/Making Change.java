
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int C,N;
    public static int[][] dp;
    public static int[] arr;

    public static void main(String[] args) throws Exception {

        init();

        for(int i=1;i<=N;i++){
            for(int j=1;j<=C;j++){
                dp[i][j] = dp[i-1][j];

                if(j - arr[i] >= 0 && dp[i][j-arr[i]] != Integer.MAX_VALUE){
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-arr[i]] + 1);
                }
            }
        }

        System.out.println(dp[N][C]);
    }

    public static void init() throws Exception {

        st = new StringTokenizer(in.readLine());

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(in.readLine().split(" ")[0]);
        }

        dp = new int[N+1][C+1];

        for(int i=0;i<=N;i++){
            for(int j=0;j<=C;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<=N;i++){
            dp[i][0] = 0;
        }
    }
}