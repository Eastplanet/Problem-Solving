
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        int N = Integer.parseInt(in.readLine());

        long[] dp = new long[N+10];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;


        for(int i=3;i<=N;i++){

            dp[i] = Math.max(dp[i],dp[i-1]+1);
            for(int j=0;i+j<=N;j++){
                dp[i+j] = Math.max(dp[i+j], dp[i-3]*(j+2));
            }
        }

        System.out.println(dp[N]);
    }
}