import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] arr;
	static int[][] visited;
	static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int safetyDistance = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 1)continue;
				BFS(i, j);
			}
		}
		
		System.out.println(safetyDistance);
	}

	static void BFS(int y, int x) {

		visited = new int[N][M];
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] { y, x, 0 });
		visited[y][x] = 1;

		while (!q.isEmpty()) {
			
			int[] curr = q.poll();
			if(arr[curr[0]][curr[1]] == 1) {
				safetyDistance = Math.max(safetyDistance, curr[2]);
				break;
			}
			
			for (int i = 0; i < 8; i++) {
				int goy = curr[0] + dy[i];
				int gox = curr[1] + dx[i];
				if(canGo(goy, gox)) {
					visited[goy][gox] = 1;
					q.add(new int[] {goy,gox,curr[2]+1});
				}
			}
		}

	}
	static boolean canGo(int goy, int gox) {
		if(gox < 0 || gox >= M || goy < 0 || goy >= N)return false;
		if(visited[goy][gox] == 1)return false;
		return true;
	}
}