import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int[] dp;

    public static void main(String[] args) throws Exception{

        String num = in.readLine();
        dp = new int[num.length()+1];

        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=num.length();i++){

            // 0 만 아니라면 한 카드로 만들 수 있음
            if(num.charAt(i-1) != '0'){
                dp[i] = dp[i-1];
            }


            if(num.charAt(i-2) != '0' && charToInt(num.charAt(i-2),num.charAt(i-1)) <= 34){
                dp[i] += dp[i-2];
            }
        }

        System.out.println(dp[num.length()]);
    }

    public static int charToInt(char a,char b){
        int aNum = a-'0';
        aNum*=10;
        int bNum = b-'0';
        return aNum + bNum;
    }




}