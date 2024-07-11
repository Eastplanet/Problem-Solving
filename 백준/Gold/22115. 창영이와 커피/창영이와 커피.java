import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
       
    	StringTokenizer st = new StringTokenizer(in.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	int[] arr =new int[N];
    	st= new StringTokenizer(in.readLine());
    	for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
    	int[][] dp = new int[N][100001];
    	
    	for(int i=0;i<N;i++)for(int j=0;j<=100000;j++)dp[i][j] = Integer.MAX_VALUE;
    	
    	dp[0][0] = 0;
    	dp[0][arr[0]] = 1;
        
    	for(int i=1;i<N;i++) {
    		for(int j=0;j<=100000;j++) {
    			
    			dp[i][j] = dp[i-1][j];
    			if(j-arr[i] < 0 || dp[i-1][j-arr[i]] == Integer.MAX_VALUE)continue;
    			dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-arr[i]]+1);
    		}
    	}
    	
    	if(dp[N-1][K] == Integer.MAX_VALUE)System.out.println(-1);
    	else System.out.println(dp[N-1][K]);
    }


}