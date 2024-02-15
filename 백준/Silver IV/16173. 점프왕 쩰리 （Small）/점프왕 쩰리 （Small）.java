import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int N;
	static boolean flag = false;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);

		if (flag) {
			System.out.println("HaruHaru");
		} else {
			System.out.println("Hing");
		}
	}

	public static void dfs(int y, int x) {

		if (x < 0 || x >= N || y < 0 || y >= N)
			return;

		if (visited[y][x]) {
			return;
		}
		visited[y][x] = true;

		if (map[y][x] == -1) {
			flag = true;
			return;
		}

		dfs(y + map[y][x], x);
		dfs(y, x + map[y][x]);

	}
}