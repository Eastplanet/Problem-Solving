import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N,M,start,end;
	static ArrayList<Edge>[] adj;
	static int[] dist, visited;
	static ArrayList<Integer>[] prev;
	static int[][] dismissEdge;
	static int[] removeVisited;
	
	static class Node implements Comparable<Node>{
		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
		int now,dist;
		public Node(int now, int dist) {
			this.now = now;
			this.dist = dist;
		}
	}
	
	static class Edge{
		int end,dist;
		public Edge(int end, int dist) {
			this.end = end;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		while(true) {
			
			// 입력
			init();
		
			
			// 다익스트라를 위해 값 넣기
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(start, 0));
			dist[start] = 0;
			prev[start].add(-1);
			
			//다익스트라
			dijkstra(pq);
			//최소 간선 삭제
			removeNode(end);
			
			// 다익스트라를 위해 값 넣기
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[start] = 0;
			Arrays.fill(visited, 0);
			pq.add(new Node(start,0));
			dijkstra(pq);
			
			if(dist[end] == Integer.MAX_VALUE) {
				sb.append(-1).append("\n");
			}
			else {
				sb.append(dist[end]).append("\n");
			}
			
		}
		
	}
	
	static void removeNode(int num) {
		
		if(removeVisited[num] == 1)return;
		removeVisited[num] = 1;
		
		if(prev[num].size() == 1 && prev[num].get(0)== -1)return;
		
		for(int i=0;i<prev[num].size();i++) {
			
			int start = prev[num].get(i);
			int end = num;
			
			dismissEdge[start][end] = 1;
			
			removeNode(start);
		}
		
	}
	
	static void dijkstra(PriorityQueue<Node> pq) {

		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(visited[cur.now]==1)continue;
			
			visited[cur.now] = 1;
			
			for (Edge edge : adj[cur.now]) {
				if(dismissEdge[cur.now][edge.end] == 1)continue;
				
				if(dist[edge.end] > dist[cur.now]+edge.dist) {
					dist[edge.end] = dist[cur.now]+edge.dist;
					prev[edge.end].clear();
					prev[edge.end].add(cur.now);
					pq.add(new Node(edge.end,dist[edge.end]));
				}
				else if(dist[edge.end] == dist[cur.now]+edge.dist) {
					prev[edge.end].add(cur.now);
				}
			}
		}
	}
	
	public static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		if(N == 0 && M == 0) {
			System.out.println(sb);
			System.exit(0);
		}
		
		
		adj = new ArrayList[N];
		for(int i=0;i<N;i++)adj[i] = new ArrayList<>(); 
		prev = new ArrayList[N];
		for(int i=0;i<N;i++)prev[i] = new ArrayList<>(); 
		
		st = new StringTokenizer(in.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[s].add(new Edge(e,w));
		}
		dist = new int[N];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		visited = new int[N];
		
		dismissEdge = new int[N][N];
		
		removeVisited = new int[N];
		
	}
}