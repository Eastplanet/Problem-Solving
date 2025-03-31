import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N;
    public static long[][] dp;

    public static void main(String[] args) throws Exception {

        while(true){
            N = Integer.parseInt(in.readLine());
            dp = new long[N+1][N+1];
            if(N == 0){
                break;
            }
            System.out.println(topDown(N, 0));
        }
    }

    public static long topDown(int full, int half){
        // 불가능한 조건
        if(full < 0 || half < 0 || full > N || half > N){
            return 0;
        }
        // base case
        if(full == 0 && half == 0){
            return 1;
        }
        // 메모이제이션
        if(dp[full][half] != 0){
            return dp[full][half];
        }
        // 큰 알약을 먹는 경우 + 작은 알약을 먹는 경우
        return dp[full][half] = topDown(full-1,half+1) + topDown(full, half-1);
    }

}