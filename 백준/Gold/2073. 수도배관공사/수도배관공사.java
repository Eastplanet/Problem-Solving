import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static int D,P;
    public static int[][] arr;
    public static long[] dp;

    public static void main(String[] args) throws Exception{

        input();

        dp[0] = Integer.MAX_VALUE;

        for(int i=0;i<P;i++){
            for(int j=D; j>=arr[i][0]; j--){
                int pipeLeng = arr[i][0];
                if(j < pipeLeng){
                    continue;
                }

                long val = Math.min(dp[j-pipeLeng], arr[i][1]);
                dp[j] = Math.max(dp[j], val);
            }
        }
        System.out.println(dp[D]);

    }

    public static void input() throws Exception{
        st = new StringTokenizer(in.readLine());
        D = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        dp = new long[100001];

        arr = new int[P][2];
        for(int i=0;i<P;i++){
            st = new StringTokenizer(in.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
    }


}