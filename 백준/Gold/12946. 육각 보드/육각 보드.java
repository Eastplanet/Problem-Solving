import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static int N;
	public static char[][] arr;
	public static int[] dx = { 0, 1, 1, 0, -1, -1 };
	public static int[] dy = { -1, -1, 0, 1, 1, 0 };
	public static int[][] visited, color;
	public static int maxColor;

	public static final int RED = -1, BLUE = 1;

	public static void main(String[] args) throws Exception {
		
		init();
		BFS();
		System.out.println(maxColor);

	}

	public static void BFS() {

		Queue<Node> q = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				if (arr[i][j] == 'X' && visited[i][j] == 0) {

					visited[i][j] = 1;
					color[i][j] = RED;
					q.add(new Node(j, i, RED));

					while (!q.isEmpty()) {
						Node curr = q.poll();

						// 갈 수 있는 곳의 d(델타)를 저장한다.
						// d가 1차이 난다는 뜻은 이웃이라는 뜻
						List<Integer> canGoList = new ArrayList<>();

						for (int d = 0; d < dx.length; d++) {
							int gox = curr.x + dx[d];
							int goy = curr.y + dy[d];

							if (gox < 0 || gox >= N || goy < 0 || goy >= N || arr[goy][gox] != 'X') {
								continue;
							}
							
							canGoList.add(d);
							
							if(visited[goy][gox] == 1) {
								
								// 2가지 색으로 불가능한 경우
								if(color[goy][gox] == curr.color) {
									maxColor = 3;
									return;
								}
								continue;
							}

							visited[goy][gox] = 1;
							color[goy][gox] = curr.color * -1;
							q.add(new Node(gox, goy, curr.color * -1));
						}

						int color;

						// color 가 1인경우만 걸러준다. 
						// color 나머지는 2로하고 3인경우는 위의 분기에서 걸러진다.
						if(canGoList.size() == 0) {
							color = 1;
						}
						else {
							color = 2;
						}
						maxColor = Math.max(maxColor, color);
					}
				}
			}
		}
	}
	
	public static void init() throws Exception {
		N = Integer.parseInt(in.readLine());
		arr = new char[N][N];
		visited = new int[N][N];
		color = new int[N][N];
		for (int i = 0; i < N; i++) {
			String tmp = in.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = tmp.charAt(j);
			}
		}
	}

	public static class Node {
		int x, y, color;

		public Node(int x, int y, int color) {
			this.x = x;
			this.y = y;
			this.color = color;
		}
	}

}