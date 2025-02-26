import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static int N;
    public static boolean[] isNotPrime;
    public static int[][] dp;

    public static void main(String[] args) throws Exception{

        init();
        erathosthenes();

        // 11 은 무시
        isNotPrime[11] = true;


        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i > 1){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                }
                if(j > 1){
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                }

                dp[i][j] += isPrime(concatTwoInt(i,j));
            }
        }

        System.out.println(dp[N][N]);
    }

    public static void init() throws Exception{
        N = Integer.parseInt(in.readLine());
        dp = new int[N+1][N+1];
        isNotPrime = new boolean[1_000_000];
    }

    // 소수이면 1 리턴, 소수가 아니면 0 리턴
    public static int isPrime(int num){
        if(isNotPrime[num] == false){
            return 1;
        }
        return 0;
    }

    public static void erathosthenes(){

        for(int i=2;i<Math.sqrt(1_000_000);i++){
            for(int j=2;i*j < 1_000_000; j++){
                isNotPrime[i*j] = true;
            }
        }
    }

    public static int concatTwoInt(int first, int second){

        int ten = 10;
        for(int i=1;i<=3;i++){
            if(second < ten){
                return first * ten + second;
            }
            ten *= 10;
        }
        return first * ten + second;
    }


}