import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int min = Integer.MAX_VALUE;
	static int N;
	static int[][] arr;
	static int[] visited;
	static int[] perm;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		visited = new int[N];
		perm = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited[0] = 1;
		perm[0] = 0;

		back(1);

		System.out.println(min);
	}

	public static void back(int idx) {

		if (idx == N) {
			int prev = 0;
			int sum = 0;
			for (int i = 1; i < N; i++) {
				if (arr[prev][perm[i]] == 0) {
					return;
				}
				sum += arr[prev][perm[i]];
				prev = perm[i];
			}
			if (arr[prev][0] == 0)return;
			sum += arr[prev][0];

			if (min > sum)min = sum;
			return;
		}

		for (int i = 1; i < N; i++) {
			if (visited[i] == 1)continue;
			visited[i] = 1;
			perm[idx] = i;
			back(idx + 1);
			visited[i] = 0;
		}
	}
}