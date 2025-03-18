import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N,M,H;
    public static int[][] dp;
    public static List<Integer>[] list;

    public static void main(String[] args) throws Exception {

        init();

        dp[0][0] = 1;

        for(int i=1;i<=N;i++){
            for(int j=0;j<=1000;j++){

                for(int blockHeight : list[i]){
                    if(blockHeight <= j){
                        dp[i][j] = ((dp[i][j]%10007) + (dp[i-1][j-blockHeight]%10007))%10007;
                    }
                }
            }
        }
        System.out.println(dp[N][H] % 10007);
    }

    public static void init() throws Exception{
        st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        dp = new int[N+1][1001];

        list = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            list[i] = new ArrayList<>();
            st = new StringTokenizer(in.readLine());

            int size = st.countTokens();
            for(int j=0;j<size;j++){
                list[i].add(Integer.parseInt(st.nextToken()));
            }
            list[i].add(0);
        }


    }

}

