import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] u;

	static int find(int a) {
		if (u[a] == a)
			return a;
		return u[a] = find(u[a]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return;
		u[a] = b;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		u = new int[N+1];
		for (int i = 0; i < N+1; i++)u[i] = i;


		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		int cnt = 0;
		st = new StringTokenizer(in.readLine());
		int prev = -1;
		for(int i=0;i<N;i++) {
			int now = Integer.parseInt(st.nextToken());
			if(prev == -1) {
				prev = now;
				continue;
			}
			
			if(find(prev) != find(now)) {
				cnt++;
				prev = now;
			}
		}
		System.out.println(cnt);
	}
}