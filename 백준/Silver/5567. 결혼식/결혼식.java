import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static StringTokenizer st;
	public static int N,M,cnt;
	public static List<Integer>[] adj;
	public static int[] visited;
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		visited = new int[N+1];
		
		adj = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			adj[i] = new ArrayList<>();
		}
		
		int M = Integer.parseInt(in.readLine());
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			adj[A].add(B);
			adj[B].add(A);
		}
		
		
		Queue<Node> q = new ArrayDeque<>();
		
		q.add(new Node(1,0));
		
		visited[1] = 1;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			for(int next : adj[curr.num]) {
				if(visited[next] == 1) {
					continue;
				}
				visited[next] =  1;
				cnt++;
				
				if(curr.dist == 1) {
					continue;
				}
				q.add(new Node(next,curr.dist + 1));
				
			}
		}
		
		System.out.println(cnt);

		

	}
	
	public static class Node{
		int num, dist;
		public Node(int num, int dist) {
			this.num = num;
			this.dist = dist;
		}
	}


}