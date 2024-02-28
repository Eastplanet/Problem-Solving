import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			dp = new long[N+1][M+1];

			System.out.println(recv(N, M));
		}
	}

	static long recv(int n, int m) {
		if (dp[n][m] != 0)
			return dp[n][m];

		if (n == m)
			return 1;
		
		if(n == 1)return m;

		long sum = 0;
		for (int i = m - 1; i >= n-1; i--) {
			sum += recv(n - 1, i);
		}

		return dp[n][m] = sum;
	}

}