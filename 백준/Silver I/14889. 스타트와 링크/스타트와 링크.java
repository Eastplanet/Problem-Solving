import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] arr;
	static int[] visited;
	static int min = Integer.MAX_VALUE;

	public static void back(int idx, int count) {

		if (count == N / 2) {
			int A = calc(1);
			int B = calc(0);

			if (Math.abs(A - B) < min) {
				min = Math.abs(A - B);
			}

			return;
		}

		for (int i = idx; i < N; i++) {
			if (visited[i] == 1)
				continue;

			visited[i] = 1;
			back(i + 1, count + 1);
			visited[i] = 0;
		}
	}

	public static int calc(int flag) {

		int sum = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (visited[i] == flag && visited[j] == flag) {
					sum += arr[i][j];
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(in.readLine());
		visited = new int[N];
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		back(0, 0);
		System.out.println(min);

	}

}