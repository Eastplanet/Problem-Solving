import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] subset;
	static int[] people;
	static ArrayList<Integer>[] adj;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());
		subset = new int[N + 1];
		people = new int[N + 1];
		adj = new ArrayList[N + 1];

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
			st = new StringTokenizer(in.readLine());
			int M = Integer.parseInt(st.nextToken());
			for(int j=0;j<M;j++) {
				int next = Integer.parseInt(st.nextToken());
				adj[i].add(next);
			}
		}
		
		getSub(1, 0);
		
		if(min == Integer.MAX_VALUE) {
			System.out.println("-1");
		}
		else {
			System.out.println(min);
		}
		

	}

	public static void getSub(int idx, int count) {

		if (idx == N + 1) {
			if (count == 0 || count == N) {
				return;
			}

			// A구역 BFS
			int[] visited = new int[N + 1];
			Queue<Integer> q = new ArrayDeque<>();
			for (int i = 1; i <= N; i++) {
				if (subset[i] == 1) {
					q.add(i);
					visited[i] = 1;
					break;
				}
			}

			
			int Asum = 0;
			
			while (!q.isEmpty()) {
				int curr = q.poll();
				Asum += people[curr];

				for (int next : adj[curr]) {
					if (visited[next] == 1)
						continue;
					if (subset[next] != 1)
						continue;

					visited[next] = 1;
					q.add(next);
				}
			}

			boolean flag = true;
			for (int i = 1; i <= N; i++) {
				if(subset[i] == 0)continue;
				
				if( subset[i] == 1 && visited[i] ==1 )continue;
				flag=false;
			}
			
			if(flag == false) {
				return;
			}
			
			
			//B 구역 BFS
			q = new ArrayDeque<>();
			visited = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				if (subset[i] == 0) {
					q.add(i);
					visited[i] = 1;
					break;
				}
			}

			
			int Bsum = 0;
			
			while (!q.isEmpty()) {
				int curr = q.poll();
				Bsum += people[curr];

				for (int next : adj[curr]) {
					if (visited[next] == 1)
						continue;
					if (subset[next] != 0)
						continue;

					visited[next] = 1;
					q.add(next);
				}
			}

			flag = true;
			for (int i = 1; i <= N; i++) {
				if(subset[i] == 1)continue;
				if(subset[i] == 0 && visited[i] ==1)continue;
				flag=false;
			}
			
			if(flag == false) {
				return;
			}
			
			
			if(min > Math.abs(Asum-Bsum))min = Math.abs(Asum-Bsum);
			

			return;
		}

		for (int i = idx; i <= N; i++) {
			if (subset[i] == 1)
				continue;

			subset[i] = 1;
			getSub(i + 1, count + 1);
			subset[i] = 0;
			getSub(i + 1, count);
		}

	}
}