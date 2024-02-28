import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		int[][] dp = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int tmp = 0;
				if(i != 0)tmp = Math.max(tmp, dp[i-1][j]);
				if(j != 0)tmp = Math.max(tmp, dp[i][j-1]);
				if(i != 0 && j != 0) tmp = Math.max(tmp, dp[i-1][j-1]);
				dp[i][j] = tmp + arr[i][j];
			}
		}
		
		System.out.println(dp[N-1][M-1]);
	}
}