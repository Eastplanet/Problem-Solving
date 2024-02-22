import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][N + 1];

		for (int i = 0; i <= N; i++) {
			Arrays.fill(arr[i], 1000000);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[start][end] = 1;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
//					if (i == j || i == k || j == k)
//						continue;

					if (arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}

				}
			}
		}

		int count = 0;
		for (int i = 1; i <= N; i++) {
			boolean flag = true;

			int c = 0;

			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;
//				
//				if (arr[i][j] == 1000000 && arr[j][i] == 1000000) {
//					flag = false;
//					break;
//				}
				if (arr[i][j] != 1000000 || arr[j][i] != 1000000) {
					c++;
				}

			}

			if (c == N - 1) {
				count++;
			}

//			if (flag)
//				count++;
		}

		System.out.println(count);

	}
}