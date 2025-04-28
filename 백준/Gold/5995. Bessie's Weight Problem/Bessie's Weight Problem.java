
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int H,N;
    public static int[] arr,dp;

    public static void main(String[] args) throws Exception {

        int max = 0;

        init();

        dp[0] = 1;

        for(int i=1;i<=N;i++){
            for(int j=0;j<=H;j++){
                if(dp[j] != 0 && (j + arr[i]) <= H){
                    dp[j+arr[i]] = 1;
                    max = Math.max(max, j+arr[i]);
                }
            }
        }

        System.out.println(max);
    }

    public static void init() throws Exception{
        st = new StringTokenizer(in.readLine());

        H = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        dp = new int[H+1];

        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(in.readLine());
        }

    }



}