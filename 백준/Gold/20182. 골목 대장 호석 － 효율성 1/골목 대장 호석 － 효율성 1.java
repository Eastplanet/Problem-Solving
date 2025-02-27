import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int N,M,A,B,C;
	public static List<Edge>[] adj;
	
	public static void main(String[] args) throws Exception {
		
		input();
		
		int start = 1;
		int end = 20;
		
		int min = Integer.MAX_VALUE;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(BFS(mid)) {
				min = Math.min(min, mid);
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(min);
		}
	}
	
	
	// maxTax내에 도달할 수 있는 지
	public static boolean BFS(int maxTax) {
		
		int[] visited = new int[N+1];
		
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(A,0));
		visited[A] = 1;
		
		while(!q.isEmpty()) {
			Node curr =  q.poll();
			
			if(curr.num == B) {
				return true;
			}
			
			for(Edge edge : adj[curr.num]) {
				
				// 방문했거나, maxTax를 넘는 비용이거나, 총 비용이 C를 초과하면 스킵
				if(visited[edge.next] == 1 || edge.weight > maxTax || curr.total + edge.weight > C) {
					continue;
				}
				
				visited[edge.next] = 1;
				q.add(new Node(edge.next, curr.total + edge.weight));
				
			}
		}
		
		return false;
	}
	
	public static void input() throws Exception {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[s].add(new Edge(e,w));
			adj[e].add(new Edge(s,w));
		}
	}
	
	public static class Node{
		int num, total;
		public Node(int num, int total) {
			this.num = num;
			this.total = total;
		}
	}

	public static class Edge{
		int next,weight;
		public Edge(int next, int weight) {
			this.next = next;
			this.weight = weight;
		}
	}
}