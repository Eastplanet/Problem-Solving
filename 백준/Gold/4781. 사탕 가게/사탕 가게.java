import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static int N, M;
    public static int[][] arr;
    public static int[] dp;

    public static void main(String[] args) throws Exception{

        while(input()){

            for(int i=0;i<N;i++){

                int candyCal = arr[i][0];
                int candyPrice = arr[i][1];

                for(int j=0;j<=M;j++){

                    if(j >= candyPrice){
                        dp[j] = Math.max(dp[j], dp[j-candyPrice] + candyCal);
                    }

//                    if(j > 0){
//                        dp[j] = Math.max(dp[j], dp[j-1]);
//                    }


                }
            }
            System.out.println(dp[M]);

        }


    }

    public static boolean input() throws Exception{

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        double tmpM = Double.parseDouble(st.nextToken());
        M = (int)(tmpM * 100 + 0.5);
        if(N == 0){
            return false;
        }

        arr = new int[N][2];
        dp = new int[M+1];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(in.readLine());
            int cal = Integer.parseInt(st.nextToken());
            double tmpPrice = Double.parseDouble(st.nextToken());
            int price = (int)(tmpPrice * 100 + 0.5);
            arr[i][0] = cal;
            arr[i][1] = price;
        }

        return true;
    }


}