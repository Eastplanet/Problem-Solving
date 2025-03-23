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
	public static int[] visited, color;
	
	public static void main(String[] args) throws Exception {
		
		int T = Integer.parseInt(in.readLine());
		while(T-- > 0) {
			init();
			if(isPossibleTwoColor()) {
				System.out.println("possible");
			}
			else {
				System.out.println("impossible");
			}
		}
	}
	
	public static boolean isPossibleTwoColor() {
		// BFS
		Queue<int[]> q = new ArrayDeque<>();
		
		for(int i=1;i<=N;i++) {
			
			if(visited[i] == 1) {
				continue;
			}
	
			q.add(new int[] {i,1});
			visited[i] = 1;
			color[i] = 1;
			
			while(!q.isEmpty()) {
				int[] curr = q.poll();
				
				for(int next : adj[curr[0]]) {
					if(visited[next] == 1) {
						if(curr[1] == color[next]) {
							return false;
						}
						continue;
					}
					visited[next] = 1;
					q.add(new int[] {next, curr[1]^1});
					color[next] = curr[1]^1;
				}
			}
		}
		
		
		return true;
	}
	
	
	public static void init() throws Exception {
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new int[N+1];
		color = new int[N+1];
		
		for(int i=0;i<=N;i++) {
			color[i] = -1;
		}
		
		adj = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
	}
	
}