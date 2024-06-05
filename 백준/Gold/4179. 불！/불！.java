import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static char[][] map;
	static int[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static boolean canGo(int goy, int gox) {
		if (goy < 0 || goy >= R || gox < 0 || gox >= C)
			return false;
		if (visited[goy][gox] == 1)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new int[R][C];
		

		Queue<int[]> JQue = new ArrayDeque<>();
		Queue<int[]> FQue = new ArrayDeque<>();

		for (int i = 0; i < R; i++) {
			String tmp = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);

				if (map[i][j] == 'J') {
					JQue.add(new int[] { i, j });
					visited[i][j] = 1;
					map[i][j] = '.';
				} else if (map[i][j] == 'F') {
					FQue.add(new int[] { i, j });
					visited[i][j] = 1;
					map[i][j] = '.';
				}
			}
		}

		int time = 0;
		while (!FQue.isEmpty() || !JQue.isEmpty()) {
			
			Queue<int[]> nextFQue = new ArrayDeque<>();
			// 불 BFS
			while (!FQue.isEmpty()) {
				int[] curr = FQue.poll();

				for (int i = 0; i < 4; i++) {
					int gox = curr[1] + dx[i];
					int goy = curr[0] + dy[i];
					if (canGo(goy, gox) && map[goy][gox] == '.') {
						visited[goy][gox] = 1;
						nextFQue.add(new int[] { goy, gox });

					}
				}
			}
			FQue = nextFQue;
			

			Queue<int[]> nextJQue = new ArrayDeque<>();
			// 지훈 BFS
			while (!JQue.isEmpty()) {
				int[] curr = JQue.poll();
				
				if (curr[0] == 0 || curr[0] == R - 1 || curr[1] == 0 || curr[1] == C - 1) {
					System.out.println(time + 1);
					return;
				}
				

				for (int i = 0; i < 4; i++) {
					int gox = curr[1] + dx[i];
					int goy = curr[0] + dy[i];
					if (canGo(goy, gox) && map[goy][gox] == '.') {
						if (goy == 0 || goy == R - 1 || gox == 0 || gox == C - 1) {
							System.out.println(time + 2);
							return;
						}
						visited[goy][gox] = 1;
						nextJQue.add(new int[] { goy, gox });

					}
				}
			}
			JQue = nextJQue;
			
			time++;
		}
		
		System.out.println("IMPOSSIBLE");

		

	}
}