import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] arr;
	static int[][] visited;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static int maximumStart, minimumEnd;
	
	static int minVal = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		BS();
		System.out.println(minVal);

	}

	static void BS() {
		
		maximumStart = Math.min(arr[0][0], arr[N-1][N-1]);
		minimumEnd = Math.max(arr[0][0], arr[N-1][N-1]);
		
		for(int i=0;i<=maximumStart;i++) {
			// high 범위 조정
			int start = minimumEnd;
			int end = 200;
			while (start <= end) {
				int mid = (start + end) / 2;
				if (canGoal(i, mid)) {
					
					minVal = Math.min(minVal, Math.abs(i-mid));
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
			
			int debug = 1;
		}
	}


	static boolean canGoal(int min, int max) {

		Queue<Pos> q = new ArrayDeque<>();
		q.add(new Pos(0, 0));
		visited = new int[N][N];
		visited[0][0] = 1;

		while (!q.isEmpty()) {
			Pos curr = q.poll();

			if (curr.y == N - 1 && curr.x == N - 1) {
				return true;
			}

			for (int i = 0; i < 4; i++) {
				int gox = curr.x + dx[i];
				int goy = curr.y + dy[i];
				if (canGo(goy, gox)) {

					if (min <= arr[goy][gox] && arr[goy][gox] <= max) {
						visited[goy][gox] = 1;
						q.add(new Pos(goy, gox));
					}

				}
			}
		}

		return false;
	}

	static boolean canGo(int goy, int gox) {
		if (gox < 0 || gox >= N || goy < 0 || goy >= N)
			return false;
		if (visited[goy][gox] == 1)
			return false;
		return true;
	}

	static class Pos {
		int y, x;

		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}
}