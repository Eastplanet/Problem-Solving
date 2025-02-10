import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int M,N,K, start, end;
	public static HashSet<Turn> set;
	public static List<int[]>[] adj;
	// visited[a][b] = 1; -> a에서 b로 온적이 있다.
	public static int[] visited;
	
	// 두개의 v를 하나의 idx로 압축 (v1,v2) -> idx
	public static HashMap<Edge, Integer>map;

	public static void main(String[] args) throws Exception {

		input();
		
		PriorityQueue<Node> Q = new PriorityQueue<>((Node o1, Node o2)->{
			return o1.length - o2.length;
		});
		
		Q.add(new Node(start,-1,0));
		while(!Q.isEmpty()) {
			Node curr = Q.poll();
			
			// 도착 시 종료
			if(curr.now == end) {
				System.out.println(curr.length);
				return;
			}
			
			
			// next[0] : V , next[1] : length
			for(int[] next : adj[curr.now]) {
				int v = next[0];
				int leng = next[1];
				
				int edgeIdx = map.get(new Edge(curr.now, v));
				
				// 방문한 적이 있는지 확인
				if(visited[edgeIdx] == 1) {
					continue;
				}
				
				// 금지된 턴에 포함되어 있는지 확인
				Turn check = new Turn(curr.prev,curr.now,v);
				if(set.contains(check)) {
					continue;
				}
				
				visited[edgeIdx] = 1;
				Node node = new Node(v ,curr.now,curr.length + leng);
				Q.add(node);
			}
		}
		
		
		System.out.println(-1);

	}
	
	public static void input() throws Exception {
		st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		adj = new List[N];
		for(int i=0;i<N;i++) {
			adj[i] = new ArrayList<>();
		}
		visited = new int[M];
		
		st = new StringTokenizer(in.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		map = new HashMap<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[s].add(new int[]{e,w});
			// s에서 e로 가는 Edge를 하나의 숫자로 압축, visited의 메모리 사용을 줄이기 위해
			map.put(new Edge(s,e), i);
		}
		
		set = new HashSet<>();
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(in.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int v3 = Integer.parseInt(st.nextToken());
			set.add(new Turn(v1, v2, v3));
		}
	}
	
	// prev -> now -> next 가 forbidden turn 인지 확인한 뒤 Queue에 넣는다.
	public static class Node {
		
		int now, prev, length;
		
		public Node(int now,int prev, int length) {
			this.now = now;
			this.prev = prev;
			this.length = length;
		}
	}
	
	public static class Edge {
		int v1,v2;
		public Edge(int v1, int v2) {
			this.v1 = v1;
			this.v2 = v2;
		}
		
		@Override
		public boolean equals(Object o) {
			if(this == o) return true;
			if(o == null || getClass() != o.getClass()) return false;
			Edge t = (Edge) o;
			return this.v1 == t.v1 && this.v2 == t.v2;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(v1+v2);
		}
		
	}
	
	
	public static class Turn {
		int first,second,third;
		
		public Turn(int first,int second, int third) {
			this.first = first;
			this.second = second;
			this.third = third;
		}
		
		@Override
		public boolean equals(Object o) {
			if(this == o) return true;
			if(o == null || getClass() != o.getClass()) return false;
			Turn t = (Turn) o;
			return this.first == t.first && this.second == t.second && this.third == t.third;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(first+second+third);
		}
	}

}