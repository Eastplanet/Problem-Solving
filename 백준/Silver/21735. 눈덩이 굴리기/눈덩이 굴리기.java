import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
	
		st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		
		st = new StringTokenizer(in.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N+1][M+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=0;j<=M;j++) {
				dp[i][j] = -1;
			}
		}
		
		dp[0][0] = 1;
		dp[1][1] = 1+arr[1];
		
		for(int i=2;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(dp[i-1][j-1] != -1) {
					dp[i][j] = Math.max(dp[i-1][j-1]+arr[i], dp[i][j]);
				}
				if(dp[i-2][j-1] != -1) {
					dp[i][j] = Math.max(dp[i][j], dp[i-2][j-1]/2+arr[i]);
				}
				
				
			}
		}
		
		int max = 0;
		for(int i=1;i<=N;i++) {
			max = Math.max(dp[i][M], max);
		}
		for(int i=0;i<=M;i++) {
			max = Math.max(dp[N][i], max);
		}
		
		System.out.println(max);
		
	}
	

}