
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static final int MOD = 100999;
    public static final int MAX = 2000;

    public static void main(String[] args) throws Exception {

        int[][] dp = new int[MAX+1][MAX+1];

        for(int i=0;i<=MAX;i++){
            dp[0][i] = 1;
        }

        for(int i=1;i<=MAX;i++){
            for(int j=1;j<=MAX;j++){
                dp[i][j] = dp[i][j-1];
                if(i >= j){
                    dp[i][j] = (dp[i][j]%MOD + dp[i-j][j-1]%MOD)%MOD;
                }

            }
        }


        int T = Integer.parseInt(in.readLine());

        while(T-- > 0){

            int N = Integer.parseInt(in.readLine());
            System.out.println(dp[N][N]);
        }



    }
}