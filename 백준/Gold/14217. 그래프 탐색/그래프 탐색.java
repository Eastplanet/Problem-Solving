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
	public static int N;
	public static List<Integer>[] adj;

	public static void main(String[] args) throws Exception {

		init();

		int Q = Integer.parseInt(in.readLine());

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(in.readLine());

			int a = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			checkAndUpdateEdge(a, start, end);

			int[] result = BFS();

			for (int j=1;j<=N;j++) {
				System.out.print(result[j] + " ");		
			}
			System.out.println();
		}
	}
	
	public static int[] BFS() {
		
		int[] result = new int[N+1];
		for(int i=1;i<=N;i++) {
			result[i] = -1;
		}
		
		
		int[] visited = new int[N+1];
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {1,0});
		visited[1] = 1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			result[curr[0]] = curr[1];
			
			for(int next : adj[curr[0]]) {
				if(visited[next] == 1) {
					continue;
				}
				visited[next] = 1;
				q.add(new int[] {next,curr[1]+1});
			}
		}
		
		return result;
	}

	public static void checkAndUpdateEdge(int a, int start, int end) {

		if (a == 1) {
			adj[start].add(end);
			adj[end].add(start);
		} else {
			adj[start].remove(adj[start].indexOf(end));
			adj[end].remove(adj[end].indexOf(start));
		}
	}

	public static void init() throws Exception {

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj[a].add(b);
			adj[b].add(a);
		}
	}

}