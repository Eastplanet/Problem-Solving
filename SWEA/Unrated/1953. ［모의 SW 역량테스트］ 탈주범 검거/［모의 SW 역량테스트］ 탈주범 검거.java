import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int[][] map, visited;
	static int N, M, R, C, L;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	// pipes [1] 1번 파이프 형태가 오갈 수 있는 방향
	static int[][] pipes = { { -1 }, { 0, 1, 2, 3 }, { 0, 2 }, { 1, 3 }, { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new int[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Queue<Integer[]> q = new ArrayDeque<>();
			q.add(new Integer[] { R, C, 1 });
			visited[R][C] = 1;
			
			int routeCount = 0;

			while (!q.isEmpty()) {
				Integer[] curr = q.poll();
				int currPipe = map[curr[0]][curr[1]];
				
				routeCount++;
				
				if(curr[2] == L) {
					continue;
				}

				for (int goDirection : pipes[currPipe]) {
					int goy = dy[goDirection] + curr[0];
					int gox = dx[goDirection] + curr[1];
					if (!isIn(gox, goy)) continue;
					if(visited[goy][gox]==1) continue;
					
					int nextPipe = map[goy][gox];
					// 다음 파이프 방향 중 현재 파이프와 반대 방향이 있는지 (연결 되어 있는 지 확인)
					if(!isConnected(goDirection, nextPipe)) continue;
					
					visited[goy][gox] = 1;
					q.add(new Integer[] {goy,gox,curr[2] + 1});

				}
			}
			
			sb.append("#"+tc+" "+routeCount).append("\n");

		}
		
		System.out.println(sb);
	}

	//연결되어 있다면 true
	static boolean isConnected(int goDirection, int nextPipe) {
		boolean connectionFlag = false;
		for (int nextDirection : pipes[nextPipe]) {
			if ((goDirection + 2) % 4 == nextDirection) {
				connectionFlag = true;
			}
		}
		return connectionFlag;
	}

	static boolean isIn(int x, int y) {
		if (x < 0 || x >= M)
			return false;
		if (y < 0 || y >= N)
			return false;
		if (map[y][x] == 0)
			return false;
		return true;
	}
}