import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map, visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] dist = new int[7][7];
	static int[] disjoint = new int[7];
	static Queue<int[]> q;
	
	static class Node implements Comparable<Node>{
		int start,end;
		int dist;
		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
		public Node(int start, int end, int dist) {
			super();
			this.start = start;
			this.end = end;
			this.dist = dist;
		}
		
	}
	
	static int find(int a) {
		if(disjoint[a] < 0)return a;
		return disjoint[a] = find(disjoint[a]);
	}
	
	static void merge(int a,int b) {
		a = find(a);
		b = find(b);
		if(a==b)return;
		
		disjoint[a] += disjoint[b];
		disjoint[b] = a;
	}

	static boolean isIn(int x, int y) {
		if (x < 0 || x >= M) return false;
		if (y < 0 || y >= N) return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		
		init();
		
		int cnt = 1;
		// 각 섬들을 고유 번호로 표시
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && visited[i][j] == 0) {
					visited[i][j] = 1;
					q.add(new int[] { i, j });
					BFS(q, cnt);
					cnt++;
				}
			}
		}
		
		
		// 섬간의 최소 거리 구하기
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				// 모든 땅에서 4방탐색으로 나아가본다.
				if(map[i][j]!=0) {
		
					for(int k=0;k<4;k++) {
						//또다른 섬을 만날 때 까지 직진
						int gox = j + dx[k];
						int goy = i + dy[k];
						
						int leng = 0;
						
						while(isIn(gox, goy)) {
							
							//자기 섬과 만나면 무시
							if(map[goy][gox] == map[i][j]) {
								break;
							}
							//물을 만나면 진행
							else if(map[goy][gox] == 0) {
								gox+= dx[k];
								goy+= dy[k];
								leng++;
							}
							// 다른 섬을 만나면 거리 재기
							else {
								if(leng < 2)break;
								
								int startNum = map[i][j];
								int endNum = map[goy][gox];
								if(dist[startNum][endNum] > leng) {
									dist[startNum][endNum] = leng;
									dist[endNum][startNum] = leng;
								}
								break;
							}
						}
					}
				}
			}
		}
		
		
		//MST 구하기
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int i=1;i<cnt;i++) {
			for(int j=i;j<cnt;j++) {
				if(dist[i][j]==Integer.MAX_VALUE)continue;
				pq.add(new Node(i,j,dist[i][j]));
			}
		}
		
		int lineCnt = 0;
		int lengSum = 0;
		while(lineCnt != cnt-2 && !pq.isEmpty()) {
			Node node = pq.poll();
			int start = node.start;
			int end = node.end;
			int dist = node.dist;
			if(find(start) == find(end))continue;
			
			merge(start, end);
			lengSum += dist;
			lineCnt++;
			
		}
		
		if(lengSum == 0 || lineCnt != cnt-2)System.out.println(-1);
		else System.out.println(lengSum);
		
	}
	
	static void init() throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0;i<7;i++) {
			for(int j=0;j<7;j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		Arrays.fill(disjoint, -1);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		q = new ArrayDeque<>();
		visited = new int[N][M];
	}

	static void BFS(Queue<int[]> q, int cnt) {
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			map[cur[0]][cur[1]] = cnt;
			for (int k = 0; k < 4; k++) {
				int gox = cur[1] + dx[k];
				int goy = cur[0] + dy[k];
				if (!isIn(gox, goy))continue;
				if (visited[goy][gox] == 1)continue;
				if(map[goy][gox]==0)continue;
				visited[goy][gox] = 1;
				q.add(new int[] { goy, gox });
			}
		}
	}
}