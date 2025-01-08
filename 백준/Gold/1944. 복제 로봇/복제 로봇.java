import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class Main {

	public static StringTokenizer st;
	public static int N, M, answer, keyCnt;
	public static int[][] arr, visited;
	public static PriorityQueue<Edge> pq;
	public static Node[] nodes;
	
	public static int[] u;
	
	public static int find(int num) {
		if(u[num] < 0) {
			return num;
		}
		return u[num] = find(u[num]);
	}
	
	public static boolean merge(int a,int b) {
		a = find(a);
		b = find(b);
		
		if(a == b) {
			return false;
		}
		
		u[b] += u[a];
		u[a] = b;
		
		return true;
	}

	public static void main(String[] args) throws Exception {

		init();

		// 모든 S와 key 위치에서 BFS 한번 씩 돌리기
		// pq에 오름차순으로 간선들이 넣어짐
		for(int i=1;i<=M+1;i++) {
			BFS(i);
		}
		
		// MST -> 유니온 파인드 이용
		
		int cnt = 0;
		while(!pq.isEmpty() && cnt < M) {
			Edge curr = pq.poll();
			
			// 사이클 형성 X
			if(merge(curr.start, curr.end)) {
				answer += curr.dist;
				cnt++;
			}
		}
		
		if(cnt == M) {
			System.out.println(answer);
		}
		else {
			System.out.println(-1);
		}

	}

	public static void BFS(int start) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = 0;
			}
		}

		Queue<Pos> q = new ArrayDeque<>();
		
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		Node startNode = nodes[start];
		q.add(new Pos(startNode.x,startNode.y,0));

		while (!q.isEmpty()) {
			Pos curr = q.poll();
			
			for(int i=0;i<4;i++){
				int gox = curr.x + dx[i];
				int goy = curr.y + dy[i];
				
				if(gox < 0 || gox >= N || goy < 0 || goy >= N || arr[goy][gox] == -1 || visited[goy][gox] == 1) {
					continue;
				}
				
				visited[goy][gox] = 1;
				q.add(new Pos(gox,goy,curr.dist + 1));
				
				if(arr[goy][gox] > 0) {
					int end = arr[goy][gox];
					
					pq.add(new Edge(start, end, curr.dist + 1));
					pq.add(new Edge(end, start, curr.dist + 1));
				}
				
				
				
			}
		}

	}

	public static void init() throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		pq = new PriorityQueue<>((Edge e1, Edge e2) -> {
			return e1.dist - e2.dist;
		});

		arr = new int[N][N];
		visited = new int[N][N];
		nodes = new Node[M+2];
		u = new int[M+2];
		
		for(int i=0;i<M+2;i++) {
			u[i] = -1;
		}

		int cnt = 1;

		for (int i = 0; i < N; i++) {
			String tmp = in.readLine();
			for (int j = 0; j < N; j++) {
				char a = tmp.charAt(j);
				// 벽
				if (a == '1') {
					arr[i][j] = -1;
				}
				// 빈공간
				else if (a == '0') {
					arr[i][j] = 0;
				}
				// 1번노드를 의미
				else if (a == 'S' || a == 'K') {
					nodes[cnt] = new Node(j, i);
					arr[i][j] = cnt;
					cnt++;
				}
			}
		}
	}
	
	public static class Node{
		int x,y;
		public Node(int x,int y){
			this.x = x;
			this.y = y;
		}
	}

	public static class Edge {
		int start, end, dist;

		public Edge(int start, int end, int dist) {
			this.start = start;
			this.end = end;
			this.dist = dist;
		}
	}

	public static class Pos {
		
		int x, y, dist;

		public Pos(int x,int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

}