import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static int N;
    public static int[][] dp;
    public static final int DIVIDE_NUM = 1_000_000_000;

    public static void main(String[] args) throws Exception{

        N = Integer.parseInt(in.readLine());
        dp = new int[N+1][21];

        for(int i=1;i<=N;i++){

            for(int j=0;j<=20;j++){
                // 2의 배수로 표현되지 못한다면, 타입 캐스팅 시 문제 발생 가능, 하지만 항상 2의 배수로 표현됨
                int val = (int)Math.pow(2,j);

                if(val > i){
                    break;
                }
                // 2^j 꼴로 표현되는 경우는 1가지
                if(val == i){
                    dp[i][j] = 1;
                    break;
                }

                // dp[i][j] = dp[i-2^j][0] + ... + dp[i-2^j][j]
                for(int k=0;k<=j;k++){
                    dp[i][j] = ((dp[i][j]%DIVIDE_NUM) + (dp[i-val][k]%DIVIDE_NUM))%DIVIDE_NUM;
                }

            }
        }

        long sum = 0;
        for(int i=0;i<=20;i++){
            sum = ((sum%DIVIDE_NUM) + (dp[N][i]%DIVIDE_NUM)) % DIVIDE_NUM;
        }

        System.out.println(sum);

    }


}