import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int N, M, topCnt;
	public static int[][] arr;
	public static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		input();

		// 산봉우리 개수
		topCnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] == false) {
					BFS(i, j);
				}
			}
		}
		
		System.out.println(topCnt);
	}

	public static void BFS(int y, int x) {

		int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
		int[] dy = { 1, 0, -1, -1, -1, 0, 1, 1 };

		visited[y][x] = true;
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(x, y, arr[y][x]));

		// 산봉우리 인가요
		boolean isTop = true;

		while (!q.isEmpty()) {
			Node curr = q.poll();
			
			for(int i=0;i<8;i++) {
				int gox = dx[i] + curr.x;
				int goy = dy[i] + curr.y;
				if(gox < 0 || gox >= M || goy < 0 || goy >= N) {
					continue;
				}
				
				// 나보다 높다면 여기는 산봉우리 아님
				if(arr[goy][gox] > curr.height) {
					isTop =false;
				}
				// 높이가 같고 방문하지 않았다면 같은 산봉우리로 포함
				else if(arr[goy][gox] == curr.height && !visited[goy][gox]) {
					visited[goy][gox] = true;
					q.add(new Node(gox,goy,curr.height));
				}
			}
		}
		
		if(isTop) {
			topCnt++;
		}
	}

	public static void input() throws Exception {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static class Node {
		int x, y, height;

		public Node(int x, int y, int height) {
			this.x = x;
			this.y = y;
			this.height = height;
		}
	}

}