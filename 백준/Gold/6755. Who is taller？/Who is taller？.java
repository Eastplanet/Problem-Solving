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
	public static int N,M;
	public static List<Integer>[] adj;
	
	
	public static void main(String[] args) throws Exception {
		
		init();
		
		st = new StringTokenizer(in.readLine());
		
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		Queue<Integer> Q = new ArrayDeque<>();
		int[] visited = new int[N+1];
		Q.add(p);
		visited[p] = 1;
		
		while(!Q.isEmpty()) {
			int curr = Q.poll();
			
			if(curr == q) {
				System.out.println("yes");
				return;
			}
			
			for(int next : adj[curr]) {
				if(visited[next] == 1) {
					continue;
				}
				
				visited[next] = 1;
				Q.add(next);
			}
		}
		
		visited = new int[N+1];
		Q.add(q);
		visited[q] = 1;
		
		while(!Q.isEmpty()) {
			int curr = Q.poll();
			
			if(curr == p) {
				System.out.println("no");
				return;
			}
			
			for(int next : adj[curr]) {
				if(visited[next] == 1) {
					continue;
				}
				
				visited[next] = 1;
				Q.add(next);
			}
		}
		
		System.out.println("unknown");
	}
	
	public static void init() throws Exception {
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// adj[a] 가 키가 크고 나보다 작은 애들은 b
		adj = new ArrayList[N+1];
		
		for(int i=1;i<=N;i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q= Integer.parseInt(st.nextToken());
			adj[p].add(q);
		}
		
	}
	

}