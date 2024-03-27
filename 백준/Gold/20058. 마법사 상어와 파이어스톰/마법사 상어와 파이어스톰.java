import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	/*
	 * 착하고 잘생긴 태훈이 형이 내 코드를 망치지 않을 거라고 생각해 못 봤어
	 */
	static int N, Q;
	static int[][] map;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[] last;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		N = (int) Math.pow(2, N);
		Q = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		if(N==2) {
			return;
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < Q; i++) {
			int L = Integer.parseInt(st.nextToken());
			fireStorm(L);
		}
		System.out.println(last[0]);
		System.out.println(last[1]);
	}

	static void fireStorm(int L) {
		divideSec(0, 0, N - 1, N - 1, L);
		last = getIce();
	}

	static void divideSec(int startX, int startY, int endX, int endY, int L) {

		if (endX - startX + 1 == (int) Math.pow(2, L)) {
			rotateArr(startX, startY, endX, endY);
			return;
		}

		int midX = (startX + endX) / 2;
		int midY = (startY + endY) / 2;

		divideSec(startX, startY, midX, midY, L);
		divideSec(midX + 1, startY, endX, midY, L);
		divideSec(startX, midY + 1, midX, endY, L);
		divideSec(midX + 1, midY + 1, endX, endY, L);
	}

	static void rotateArr(int startX, int startY, int endX, int endY) {

		if (startX >= endX) {
			return;
		}

		int size = endX - startX + 1;
		int[][] arr = new int[4][size];

		// top
		for (int i = 0; i < size; i++) {
			arr[0][i] = map[startY][startX + i];
		}
		// right
		for (int i = 0; i < size; i++) {
			arr[1][i] = map[startY + i][endX];
		}
		// bottom
		for (int i = 0; i < size; i++) {
			arr[2][i] = map[endY][endX - i];
		}
		// left
		for (int i = 0; i < size; i++) {
			arr[3][i] = map[endY - i][startX];
		}

		for (int i = 0; i < size; i++) {
			map[startY][startX + i] = arr[3][i];
			map[startY + i][endX] = arr[0][i];
			map[endY][endX - i] = arr[1][i];
			map[endY - i][startX] = arr[2][i];
		}

		rotateArr(startX + 1, startY + 1, endX - 1, endY - 1);

	}

	static int[] getIce() {

		int totalIce = 0;

		boolean[][] nowDeIce = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (map[i][j] == 0)
					continue;

				int cnt = 0;

				for (int k = 0; k < 4; k++) {
					int gox = j + dx[k];
					int goy = i + dy[k];
					if (isIn(gox, goy)) {
						if (map[goy][gox] == 0 && !nowDeIce[goy][gox]) {
							cnt++;
						}
					} else {
						cnt++;
					}
				}

				if (cnt >= 2) {
					map[i][j]--;
					if (map[i][j] == 0) {
						nowDeIce[i][j] = true;
					}
				}
				totalIce += map[i][j];
			}
		}

		int maxBigIce = 0;

		boolean[][] visited = new boolean[N][N];
		Queue<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					q.add(new int[] { i, j });
					visited[i][j] = true;

					int bigIce = 0;

					while (!q.isEmpty()) {
						int[] cur = q.poll();
						bigIce++;

						for (int k = 0; k < 4; k++) {
							int gox = cur[1] + dx[k];
							int goy = cur[0] + dy[k];

							if (isIn(gox, goy)) {
								if (visited[goy][gox] == false) {
									if (map[goy][gox] != 0) {

										visited[goy][gox] = true;
										q.add(new int[] { goy, gox });
									}
								}
							}
						}
					}

					if (maxBigIce < bigIce) {
						maxBigIce = bigIce;
					}
				}
			}
		}
		return new int[] { totalIce, maxBigIce };
	}

	static boolean isIn(int x, int y) {
		if (x < 0 || x >= N)
			return false;
		if (y < 0 || y >= N)
			return false;
		return true;
	}
}