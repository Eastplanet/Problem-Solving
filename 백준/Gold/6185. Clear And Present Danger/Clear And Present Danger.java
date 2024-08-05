import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static int[][] arr;
	static int[] path;

	public static void main(String[] args) throws Exception {

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		path = new int[M];
		arr = new int[N + 1][N + 1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				arr[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < M; i++) {
			path[i] = Integer.parseInt(in.readLine());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(arr[i][k] == Integer.MAX_VALUE || arr[k][j] == Integer.MAX_VALUE)continue;
					arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
		
		int sum = 0;
		for(int i=1;i<M;i++) {
			int prev = path[i-1];
			int now = path[i];
			sum += arr[prev][now];
		}
		System.out.println(sum);

	}

}