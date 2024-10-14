import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		int E = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		
		int[][] arr = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				arr[i][j] = 100_000_000;
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			arr[a][b] = time;
		}
		
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
		
		int cnt = 0;
		for(int i=1;i<=N;i++) {
			if(arr[i][E] <= T || i == E)cnt++;
		}
		
		System.out.println(cnt);
		
		
		
	}

}