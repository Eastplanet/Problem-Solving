import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int E,F,N;
    public static int[][] arr,dp;


    public static void main(String[] args) throws Exception {

        dp = new int[501][10001];
        arr = new int[501][2];


        int T = Integer.parseInt(in.readLine());
        while(T-- > 0){
            init();

            for(int i=1;i<=N;i++){
                for(int j=0;j<=F-E;j++){
                    dp[i][j]  = Math.min(dp[i][j], dp[i-1][j]);

                    if(j - arr[i][1] >= 0){
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j-arr[i][1]] + arr[i][0]);
                        dp[i][j] = Math.min(dp[i][j], dp[i][j-arr[i][1]] + arr[i][0]);
                    }
                }
            }

            if(dp[N][F-E] == 10_000_000){
                System.out.println("This is impossible.");
            }
            else{
                System.out.println("The minimum amount of money in the piggy-bank is " + dp[N][F-E] + ".");
            }
        }


    }

    public static void init() throws Exception{

        st = new StringTokenizer(in.readLine());
        E = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(in.readLine());



        for(int i=1;i<=N;i++){
            st = new StringTokenizer(in.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<=N;i++){
            for(int j=1;j<=F;j++){
                dp[i][j] = 10_000_000;
            }
        }

    }

}