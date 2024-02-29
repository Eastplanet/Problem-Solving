import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, max;
	static int[][] map;
	static int[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		max = 0;
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		back(0);
		System.out.println(max);
	}

	public static void back(int idx) {

		if (idx == 3) {
			BFS();
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (map[i][j] == 0) {
					map[i][j] = 1;
					back(idx + 1);
					map[i][j] = 0;
				}
			}
		}

	}

	public static void BFS() {
		Queue<Integer[]> q = new ArrayDeque<>();
		visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) {
					q.add(new Integer[] { i, j });
					visited[i][j] = 1;
				}
			}
		}

		while (!q.isEmpty()) {
			Integer[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int gox = cur[1] + dx[i];
				int goy = cur[0] + dy[i];
				if (!isIn(gox, goy))
					continue;
				if (visited[goy][gox] == 1)
					continue;
				visited[goy][gox] = 1;
				q.add(new Integer[] { goy, gox });
			}
		}

		int safeZoneCount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && visited[i][j] == 0) {
					safeZoneCount++;
				}
			}
		}

		if (max < safeZoneCount) {
			max = safeZoneCount;
			}
	}

	public static boolean isIn(int x, int y) {
		if (x < 0 || x >= M)
			return false;
		if (y < 0 || y >= N)
			return false;
		if (map[y][x] == 1)
			return false;
		return true;
	}

}