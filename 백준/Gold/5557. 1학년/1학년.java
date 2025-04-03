
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N;
    public static int[] arr;

    public static void main(String[] args) throws Exception {

        N = Integer.parseInt(in.readLine());
        arr = new int[N+1];

        st = new StringTokenizer(in.readLine());
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        long[][] dp = new long[N+1][21];

        dp[0][0] = 1;

        for(int i=1;i<N;i++){
            for(int j=0;j<=20;j++){
                if(0 <= j + arr[i] && j + arr[i] <= 20){
                    dp[i][j+arr[i]] += dp[i-1][j];
                }
                // 가장 처음에는 -를 사용할 수 없다 0 1 2 3 을 표현할 때 -0+1+2=3 금지
                if(0 <= j - arr[i] && j - arr[i] <= 20 && i != 1){
                    dp[i][j-arr[i]] += dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N-1][arr[N]]);
    }

}