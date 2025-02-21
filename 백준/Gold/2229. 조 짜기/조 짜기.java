import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static int N;
    public static int[] arr,dp;

    public static void main(String[] args) throws Exception{

        input();

        dp[0] = 0;

        for(int i=1;i<N;i++){

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            // dp[i] 를 구하기 위해, dp[j] + calc(i 에서 j)
            // calc는 i~j의 최대 최소값의 차이
            for(int j=i;j>=0;j--){
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);

                if(j == 0){
                    dp[i] = Math.max(dp[i], max-min);
                }
                else{
                    dp[i] = Math.max(dp[i] , dp[j-1] + max - min);
                }
            }
        }

        System.out.println(dp[N-1]);
    }

    public static void input() throws Exception {
        N = Integer.parseInt(in.readLine());

        arr = new int[N];
        dp = new int[N];

        st = new StringTokenizer(in.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

}