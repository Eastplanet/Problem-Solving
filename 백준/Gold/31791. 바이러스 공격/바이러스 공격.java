import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, Tg, Tb, X, B;
	static char[][] arr;
	static int[][] visited;
	static PriorityQueue<int[]> q;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {

		init();

		while (!q.isEmpty()) {

			int[] curr = q.poll();
			
			
			if (visited[curr[0]][curr[1]] == 1 || curr[2] > Tg) continue;
			
			visited[curr[0]][curr[1]] = 1;

			

			for (int i = 0; i < 4; i++) {
				int gox = curr[1] + dx[i];
				int goy = curr[0] + dy[i];
				if (isIn(goy, gox) && visited[goy][gox] == 0) {
					if (arr[goy][gox] == '.') {
						q.add(new int[] { goy, gox, curr[2] + 1 });
					} else if (arr[goy][gox] == '#') {
						q.add(new int[] { goy, gox, curr[2] + 1 + Tb });
					} else {
						System.out.println("ERROR");
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visited[i][j] == 0) {
					sb.append(i+1).append(" ").append(j+1).append("\n");
				}
			}
		}
		if(sb.length() == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(sb);
		}
		
		
	}

	static boolean isIn(int y, int x) {
		if (x < 0 || x >= M)
			return false;
		if (y < 0 || y >= N)
			return false;
		return true;
	}

	static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		Tg = Integer.parseInt(st.nextToken());
		Tb = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		arr = new char[N][M];
		visited = new int[N][M];
		q = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

		for (int i = 0; i < N; i++) {
			String tmp = in.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = tmp.charAt(j);
				if (arr[i][j] == '*') {
					q.add(new int[] { i, j, 0 });
					arr[i][j] = '.';
				}
			}
		}

	}
}