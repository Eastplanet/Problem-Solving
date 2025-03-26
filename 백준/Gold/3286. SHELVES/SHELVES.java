import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int N,C,R;
    public static int[] arr,dp;

    public static void main(String[] args) throws Exception {

        init();

        for(int i=1;i<=C;i++){
            dp[i] = Math.min(dp[i], dp[i-1] + arr[i]);

            // i-2까지의 필요한 높이 + i-1 과 i는 이번 경우에서 충족
            if(i-2 >= 0){
                int max = Math.max(arr[i],arr[i-1]);
                dp[i] = Math.min(dp[i], dp[i-2] + max);
            }

            // i-3까지의 필요한 높이 + i-2 i-1 i 는 이번 경우에서 충족
            if(i-3 >= 0){
                int max = Math.max(arr[i],arr[i-1]);
                max = Math.max(max,arr[i-2]);
                dp[i] = Math.min(dp[i], dp[i-3] + max);
            }
        }

        System.out.println(dp[C]);
    }

    public static void init() throws Exception{

        st = new StringTokenizer(in.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(in.readLine());

        arr = new int[C+1];
        dp = new int[C+1];

        // 해당 열의 가장 높은 높이만 가져갈 수 있으면 그 아래 물건은 항상 가져갈 수 있음을 근거로 max로 갱신
        for(int i=0;i<N;i++){
            st = new StringTokenizer(in.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            arr[c] = Math.max(arr[c], r);
        }

        for(int i=1;i<=C;i++){
            dp[i] = 100_000;
        }

    }

}