import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] adj = new ArrayList[N + 1];
		int[] indegrees = new int[N + 1];
		int[] visited = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			adj[start].add(end);
			indegrees[end]++;
		}

		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			if (indegrees[i] == 0) {
				q.add(i);
				visited[i] = 1;
			}
		}
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr+" ");
			
			for (Integer next : adj[curr]) {
				if(visited[next] == 1) {
					continue;
				}
				
				indegrees[next]--;
				if(indegrees[next] == 0) {
					q.add(next);
					visited[next] = 1;
				}
			}
		}
		
		System.out.println(sb);

	}
}