import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,K;
    static int[][] arr,dp;


    public static void main(String[] args) throws Exception{

        input();

        dp = new int[K+1][N+1];


        for(int i=1;i<=K;i++){

            for(int j=0;j<=N;j++){


                if(j != 0){
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                }

                dp[i][j] = Math.max(dp[i][j],dp[i-1][j]);

                if(j >= arr[i][1]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i][1]]+arr[i][0]);
                }
            }
        }

        System.out.println(dp[K][N]);



    }

    public static void input() throws Exception{
        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[K+1][2];

        for(int i=1;i<=K;i++){
            st = new StringTokenizer(in.readLine());
            int I = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            arr[i][0] = I;
            arr[i][1] = T;
        }
    }



}