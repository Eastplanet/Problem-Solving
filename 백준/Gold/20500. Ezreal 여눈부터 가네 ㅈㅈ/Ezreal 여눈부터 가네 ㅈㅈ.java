
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N;

    public static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception {



        N = Integer.parseInt(in.readLine());

        int[] dp = new int[N+10];

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for(int i=4;i<=N;i++){
            dp[i] = ((dp[i-2]*2)%MOD + (dp[i-1]%MOD))%MOD;
        }

        System.out.println(dp[N]);

    }
}