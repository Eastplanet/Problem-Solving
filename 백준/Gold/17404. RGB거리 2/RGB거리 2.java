import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int RED = 0;
	static final int GREEN = 1;
	static final int BLUE = 2;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		int[][] arr = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}

		// [i][c][k] i번 집에 c번을 칠할때의 최소비용 처음은 K에서 출발함
		int[][][] dp = new int[N][3][3];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<3;j++) {
				for(int k=0;k<3;k++) {
					dp[i][j][k] = 10000;
				}
			}
		}

		dp[0][RED][RED] = arr[0][RED];
		dp[0][GREEN][GREEN] = arr[0][GREEN];
		dp[0][BLUE][BLUE] = arr[0][BLUE];

		dp[1][RED][BLUE] = dp[0][BLUE][BLUE] + arr[1][RED];
		dp[1][RED][GREEN] = dp[0][GREEN][GREEN] + arr[1][RED];
		
		dp[1][GREEN][RED] = dp[0][RED][RED] + arr[1][GREEN];
		dp[1][GREEN][BLUE] = dp[0][BLUE][BLUE] + arr[1][GREEN];
		
		dp[1][BLUE][RED] = dp[0][RED][RED] + arr[1][BLUE];
		dp[1][BLUE][GREEN] = dp[0][GREEN][GREEN] + arr[1][BLUE];
		

		for (int i = 2; i < N; i++) {
			// 빨 초 빨 or 파 초 빨
			for(int color = 0;color < 3;color++ ) {
				int prev;
				
				prev = Math.min(dp[i - 2][RED][color] + arr[i - 1][GREEN], dp[i - 2][BLUE][color] + arr[i - 1][GREEN]);
				prev = Math.min(prev, dp[i - 2][RED][color] + arr[i - 1][BLUE]);
				prev = Math.min(prev, dp[i - 2][GREEN][color] + arr[i - 1][BLUE]);
				dp[i][RED][color] = prev + arr[i][RED];
				
				

				prev = Math.min(dp[i - 2][GREEN][color] + arr[i - 1][RED], dp[i - 2][BLUE][color] + arr[i - 1][RED]);
				prev = Math.min(prev, dp[i - 2][RED][color] + arr[i - 1][BLUE]);
				prev = Math.min(prev, dp[i - 2][GREEN][color] + arr[i - 1][BLUE]);
				dp[i][GREEN][color] = prev + arr[i][GREEN];

				prev = Math.min(dp[i - 2][BLUE][color] + arr[i - 1][RED], dp[i - 2][GREEN][color] + arr[i - 1][RED]);
				prev = Math.min(prev, dp[i - 2][RED][color] + arr[i - 1][GREEN]);
				prev = Math.min(prev, dp[i - 2][BLUE][color] + arr[i - 1][GREEN]);
				dp[i][BLUE][color] = prev + arr[i][BLUE];
			}
		}
		
		int min = Math.min(dp[N-1][RED][GREEN] , dp[N-1][RED][BLUE]);
		min = Math.min(min, dp[N-1][GREEN][RED]);
		min = Math.min(min, dp[N-1][GREEN][BLUE]);
		min = Math.min(min, dp[N-1][BLUE][RED]);
		min = Math.min(min, dp[N-1][BLUE][GREEN]);

		System.out.println(min);

	}
}

// 빨/초/파 //빨/초/파  ?