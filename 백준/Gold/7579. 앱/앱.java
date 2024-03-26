import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] mem = new int[N + 1];
		int[] cost = new int[N + 1];
		int[][] dp = new int[N + 1][10001];

		st = new StringTokenizer(in.readLine());
		for (int j = 1; j <= N; j++) {
			mem[j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		for (int j = 1; j <= N; j++) {
			cost[j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 10001; j++) {
				int memory = mem[i];
				int icost = cost[i];
				if (j < icost) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - icost] + memory);
				}
			}
		}

		for (int i = 0; i < 10001; i++) {
			if (dp[N][i] >= M) {
				System.out.println(i);
				return;
			}
		}

	}
}