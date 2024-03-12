import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		ArrayList<Integer>[] adj = new ArrayList[N+1];
		int[] indegree = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
			indegree[a]++;
			indegree[b]++;
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i=1;i<=N;i++) {
			if(indegree[i] == 1) {
				
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			indegree[curr]--;
			for (int next : adj[curr]) {
				indegree[next]--;
				if(indegree[next]==1) {
					q.add(next);
				}
			}
		}
		
		//인디그리 양수면 사이클 포함
		
		int[] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for(int i=1;i<=N;i++) {
			
			
			if(indegree[i] <= 0) {
				
				int[] visited = new int[N+1];
				Queue<int[]> bfs = new ArrayDeque<>();
				visited[i] = 1;
				bfs.add(new int[] {i,0});
				
				
				while(!bfs.isEmpty()) {
					int[] curr = bfs.poll();
					
					if(indegree[curr[0]] > 0) {
						System.out.print(curr[1]+ " ");
						break;
					}
					
					for (int next : adj[curr[0]]) {
						if(visited[next] != 1) {
							visited[next] = 1;
							bfs.add(new int[] {next,curr[1]+1});
						}
					}
				}
				
			}
			else {
				System.out.print(0+" ");
			}
		}
		
	}
	
	
}