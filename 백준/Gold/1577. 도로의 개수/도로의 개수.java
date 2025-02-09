import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int N, M;
	public static int[][][] illegal;
	public static long[][] path;

	public static void main(String[] args) throws Exception {

		input();
		
		path[0][0] = 1;
		
		for(int i=0;i<=M;i++) {
			for(int j=0;j<=N;j++) {
				
				// 위에서 오는 방향을 더해준다.
				if(i != 0 && illegal[i][j][1] == 0) {
					path[i][j] += path[i-1][j];
				}
				
				// 왼쪽에서 오는 방향을 더해준다.
				if(j != 0 && illegal[i][j][0] == 0) {
					path[i][j] += path[i][j-1];
				}
			}
		}
		
		System.out.println(path[M][N]);
		
	}

	public static void input() throws Exception {
		st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		illegal = new int[M+1][N+1][2];
		path = new long[M+1][N+1];

		int K = Integer.parseInt(in.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			// (a,b)가 (c,d)보다 항상 좌표가 (0,0)에 가깝도록 변경
			if(a > c) {
				int tmp = a;
				a = c;
				c = tmp;
			}
			if(b > d) {
				int tmp = b;
				b = d;
				d = tmp;
			}

			if (a == c) {
				// 공사 도로가 아래 방향
				// 아래 방향으로 (d,c)를 갈 수 없다
				illegal[d][c][1] = 1;
			} else {
				// 공사 도로가 오른쪽 방향
				// 오른쪽 방향으로 (d,c)를 갈 수 없다.
				illegal[d][c][0] = 1;
			}

		}
	}

}