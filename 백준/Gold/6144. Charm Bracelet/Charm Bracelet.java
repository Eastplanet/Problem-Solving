
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N,M;
    public static int[][] arr,dp;

    public static void main(String[] args) throws Exception {

        init();


        for(int i=1;i<=N;i++){

            for(int j=0;j<=M;j++){
                dp[i][j] = dp[i-1][j];
                if(arr[i][0]<=j){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-arr[i][0]]+arr[i][1]);
                }
            }
        }

        System.out.println(dp[N][M]);


    }

    public static void init() throws Exception{
        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][2];
        dp = new int[N+1][12881];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(in.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
    }

}