import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Session {
		int p;
		int d;

		public Session(int p, int d) {
			this.p = p;
			this.d = d;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int D = -1;
		int N = Integer.parseInt(in.readLine());
		Session[] sessions = new Session[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			D = Math.max(D, d);
			sessions[i] = new Session(p,d);
		}

		Arrays.sort(sessions, (o1, o2) -> o2.d - o1.d);

		int moneySum = 0;
		int[] visited = new int[N];
		for (int i = D; i >= 1; i--) {
			
			
			int max = -1;
			int maxIdx = 0;
			for(int j=0;j<N;j++) {
				if(visited[j] == 0 && i <= sessions[j].d) {
					if(max < sessions[j].p) {
						max = sessions[j].p;
						maxIdx = j;
					}
				}
			}
			
			if(max != -1) {
				visited[maxIdx] =1;
				moneySum += max;
			}
			
		}
		
		System.out.println(moneySum);
	}
}