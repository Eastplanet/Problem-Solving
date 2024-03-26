import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N+1][K+1];
		int[][] items = new int[N+1][2];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(in.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			items[i][0] = w;
			items[i][1] = v;
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=K;j++) {
				if(items[i][0] > j) {
					dp[i][j] = dp[i-1][j];
				}
				else {
					int v = items[i][1];
					int w = items[i][0];
					dp[i][j] = Math.max(v + dp[i-1][j-w], dp[i-1][j]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
		
		
		
	}
}