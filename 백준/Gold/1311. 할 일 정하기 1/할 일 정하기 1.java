import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int N;
	public static int[][] dp,arr;
	
	public static void main(String[] args) throws Exception {
		
		init();
		
		int result = DP(0,0);
		System.out.println(result);
	}
	
	public static int DP(int idx, int bit) {
		
		if(idx == N) {
			return 0;
		}
		
		if(dp[idx][bit] != 1_000_000) {
			return dp[idx][bit];
		}
		
		for(int next=0;next<N;next++) {
			if(((1<<next)&bit) != 0) {
				continue;
			}
			
			dp[idx][bit] = Math.min(dp[idx][bit], DP(idx+1,((1<<next)|bit)) + arr[next][idx]);
		}
		
		return dp[idx][bit];
	}
	
	public static void init() throws Exception{
		N = Integer.parseInt(in.readLine());
		
		arr = new int[N][N];
		dp = new int[N][2<<N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<(2<<N);j++) {
				dp[i][j] = 1_000_000;
			}
		}
	}
}