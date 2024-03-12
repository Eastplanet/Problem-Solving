import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());

		ArrayList<Integer>[] adj = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}

		int[] indegree = new int[N];
		int[] orders = new int[N];

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj[a].add(b);
			adj[b].add(a);
			indegree[a]++;
			indegree[b]++;
		}

		
		//위상 정렬
		Queue<int[]> q = new ArrayDeque<>();
		for(int i=0;i<N;i++) {
			if(indegree[i] == 1) {
				indegree[i]--;
				orders[i] = 1;
				q.add(new int[] {i,2});
			}
		}
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			for (int next : adj[curr[0]]) {
				indegree[next]--;
				if(indegree[next] == 1) {
					orders[next] = curr[1];
					q.add(new int[] {next,curr[1]+1});
				}
			}
		}
		
		int maxOrder = Integer.MIN_VALUE;
		
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=0;i<N;i++) {
			//indegree = 3
			if(adj[i].size()>=3) {
				
				
				//min 으로 정렬했을 때 3번째로 큰 값
				
				int[] st = new int[adj[i].size()];
				int idx= 0 ;
				for (int next : adj[i]) {
					st[idx++] = orders[next];
				}
				
				Arrays.sort(st);
				
				int min = Integer.MAX_VALUE;
				min = st[(st.length-1)-2];
				if(maxOrder < min) {
					maxOrder = min;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			if(orders[i]>maxOrder) {
				result.add(i);
			}
		}
		
		Collections.sort(result);
		
		for(int i=0;i<result.size();i++) {
			System.out.print(result.get(i)+" ");
		}
		

	}
}