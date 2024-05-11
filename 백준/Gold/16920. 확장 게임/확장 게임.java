import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, P;
	static char[][] arr;
	static int[][] visited;
	static Queue<Pos>[] queueForPlayers;
	static int[] castleCountForPlayers;
	static int[] moveLengForPlayers;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		init();

		while (true) {
			boolean isChange = false;

			for (int i = 0; i < P; i++) {

				boolean rs = BFS(queueForPlayers[i], i);
				if (rs == true) {
					isChange = true;
				}
			}

			if (isChange == false) {
				break;
			}
		}

		for (int i = 0; i < P; i++) {
			System.out.print(castleCountForPlayers[i] + " ");
		}
	}

	static boolean BFS(Queue<Pos> q, int player) {
		Queue<Pos> nextQ = new ArrayDeque<>();
		boolean changeFlag = false;

		while (!q.isEmpty()) {

			Pos cur = q.poll();

			for (int i = 0; i < 4; i++) {

				int gox = cur.x + dx[i];
				int goy = cur.y + dy[i];

				if (canGo(goy, gox)) {
					changeFlag = true;
					visited[goy][gox] = 1;
					castleCountForPlayers[player]++;
					if (cur.leftMoveCount == 1) {
						nextQ.add(new Pos(goy, gox, moveLengForPlayers[player]));
					} else {
						q.add(new Pos(goy, gox, cur.leftMoveCount - 1));
					}
				}
			}

		}

		queueForPlayers[player] = nextQ;
		return changeFlag;
	}

	static boolean canGo(int y, int x) {
		if (x < 0 || x >= M)
			return false;
		if (y < 0 || y >= N)
			return false;
		if (visited[y][x] == 1)
			return false;
		return true;
	}

	static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		arr = new char[N][M];
		visited = new int[N][M];
		queueForPlayers = new Queue[P];
		castleCountForPlayers = new int[P];
		moveLengForPlayers = new int[P];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < P; i++) {
			moveLengForPlayers[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < P; i++) {
			queueForPlayers[i] = new ArrayDeque<Pos>();
		}

		for (int i = 0; i < N; i++) {
			String tmp = in.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = tmp.charAt(j);
				if (arr[i][j] == '#') {
					visited[i][j] = 1;
				} else if (arr[i][j] != '.') {
					visited[i][j] = 1;
					int p = arr[i][j] - '1';
					castleCountForPlayers[p]++;
					queueForPlayers[p].add(new Pos(i, j, moveLengForPlayers[p]));
				}
			}
		}
	}

	static class Pos {
		int y, x;
		int leftMoveCount;

		public Pos(int y, int x, int leftMoveCount) {
			this.y = y;
			this.x = x;
			this.leftMoveCount = leftMoveCount;
		}
	}
}