import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int[] indegree = new int[N+1];
			int[] arr = new int[N+1];
			for(int i=1;i<=N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				indegree[arr[i]]++;
			}
			
			Queue<Integer>q = new ArrayDeque<>();
			for(int i=1;i<=N;i++) {
				if(indegree[i] == 0) {
					q.add(i);
				}
			}
			
			while(!q.isEmpty()) {
				
				int num = q.poll();
				int next = arr[num];
				indegree[next]--;
				if(indegree[next] == 0) {
					q.add(next);
				}
			}
			
			int count = 0;
			for(int i=1;i<=N;i++) {
				if(indegree[i] == 0)count++;
			}
			
			System.out.println(count);
			
		}

	}
}