import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static char[][] map;
	static int[][] water;
	static int[] start = new int[2];
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] visited;

	static boolean isIn(int x, int y) {
		if (x < 0 || x >= C)
			return false;
		if (y < 0 || y >= R)
			return false;
		if (map[y][x] == 'X')
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		water = new int[R][C];
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				water[i][j] = Integer.MAX_VALUE;
			}
		}
		visited = new int[R][C];

		Queue<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			String tmp = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);
				if (map[i][j] == 'S') {
					start[0] = i;
					start[1] = j;
				} else if (map[i][j] == '*') {
					water[i][j] = 1;
					q.add(new int[] { i, j });
					visited[i][j] = 1;
				}
			}
		}

		// water BFS 돌림

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int gox = cur[1] + dx[i];
				int goy = cur[0] + dy[i];
				if (!isIn(gox, goy))
					continue;
				if (visited[goy][gox] == 1)
					continue;
				if (map[goy][gox] == '.') {
					visited[goy][gox] = 1;
					water[goy][gox] = water[cur[0]][cur[1]] + 1;
					q.add(new int[] {goy,gox});
				}

			}
		}

		visited = new int[R][C];
		q.add(new int[] { start[0], start[1], 2 });

		//
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int gox = cur[1] + dx[i];
				int goy = cur[0] + dy[i];
				if (!isIn(gox, goy))continue;
				if (visited[goy][gox] == 1)continue;
				if (map[goy][gox] == '.') {
					if(water[goy][gox] > cur[2]) {
						visited[goy][gox] = 1;
						q.add(new int[] {goy,gox,cur[2]+1});
					}
				}
				else if(map[goy][gox] == 'D') {
					System.out.println(cur[2]-1);
					return;
				}
			}
		}
		
		System.out.println("KAKTUS");

	}
}