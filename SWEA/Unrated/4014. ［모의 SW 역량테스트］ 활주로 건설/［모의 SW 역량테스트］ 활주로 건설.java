import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N, X;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			init();
			int count = 0;
			for (int i = 0; i < N; i++) {
				if (check(i, false))
					count++;
				if (check(i, true))
					count++;
			}
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}

	public static boolean check(int idx, boolean isHorizontal) {
		int[] arr;
		if (isHorizontal) {
			arr = map[idx];
		} else {
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = map[i][idx];
			}
		}
		int[] isBuild = new int[N];
		for (int i = 0; i < N - 1; i++) {
			// 높이가 다르다면
			if (arr[i] == arr[i + 1])
				continue;
			if (Math.abs(arr[i] - arr[i + 1]) >= 2)
				return false;
			// / 모양 활주로
			if (arr[i] < arr[i + 1]) {
				if (!isEnoughSpace(i - X + 1, i))
					return false;

				for (int j = i - X + 1; j <= i; j++) {
					if (arr[j] != arr[i])
						return false;
				}

				for (int j = i - X + 1; j <= i; j++) {
					if (isBuild[j] == 1)
						return false;
					isBuild[j] = 1;
				}
			}
			// \ 모양 활주로 건설
			else {
				if (!isEnoughSpace(i + 1, i + X))
					return false;

				for (int j = i + 1; j <= i + X; j++) {
					if (arr[j] != arr[i + 1])
						return false;
				}

				for (int j = i + 1; j <= i + X; j++) {
					if (isBuild[j] == 1)
						return false;
					isBuild[j] = 1;
				}
			}
		}
		return true;
	}

	public static boolean isEnoughSpace(int a, int b) {
		if (a < 0 || a >= N)
			return false;
		if (b < 0 || b >= N)
			return false;
		return true;
	}

	public static void init() throws Exception {
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}