import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[][] movepos = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int[][] map = new int[N][N];
	static int[][] dist = new int[N][N];
	static int[][] visit = new int[N][N];
	static PriorityQueue<Node> pq = new PriorityQueue<>();

	static class Node implements Comparable<Node> {
		int x, y, dist;

		Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}

	public static void main(String[] args) throws Exception {
		

		int count = 1;
		
		while (true) {
			N = Integer.parseInt(in.readLine());
			
			if (N == 0) {
				break;
			}
			
			init();
			
			for(int i=0;i<N;i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			
			dist[0][0] = map[0][0];
			pq.add(new Node(0, 0, dist[0][0]));
			
			while (!pq.isEmpty()) {
				Node curr = pq.poll();
				if(visit[curr.y][curr.x]==1)continue;
				
				visit[curr.y][curr.x] = 1;

				for(int i=0;i<4;i++) {
					int gox = curr.x + movepos[i][0];
					int goy = curr.y + movepos[i][1];
					
					if(isIn(gox,goy)) {
						if(visit[goy][gox] == 1)continue;
						
						if(dist[goy][gox] > dist[curr.y][curr.x] + map[goy][gox]) {
							dist[goy][gox] = dist[curr.y][curr.x] + map[goy][gox];
							pq.add(new Node(gox,goy,dist[goy][gox]));
						}
					}
										
				}
			}
			
			sb.append("Problem ").append(count).append(": ").append(dist[N-1][N-1]).append("\n");

			count++;
		}
		
		System.out.println(sb);
	}

	public static boolean isIn(int x, int y) {
		if (x < 0 || x >= N)
			return false;
		if (y < 0 || y >= N)
			return false;
		return true;
	}

	public static void init() throws Exception{
		map = new int[N][N];
		dist = new int[N][N];
		visit = new int[N][N];
		pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
	}

}