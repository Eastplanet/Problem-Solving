package hwalgo03_부울경_04_오동규;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_2001_파리퇴치_오동규 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			int[][] sum = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (j == 0)
						sum[i][j] = map[i][j];
					else
						sum[i][j] = sum[i][j - 1] + map[i][j];
				}
			}

			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					
					int val = 0;
					for (int k = i; k < i+M; k++) {
						int r = sum[k][j+M-1];
						int l = 0;
						if(j-1 >= 0)l = sum[k][j-1];
						val += r-l;
					}
					if(max < val)max = val;
				}
			}
			
			sb.append("#"+tc+" "+max).append("\n");
		}
		
		System.out.println(sb);
	}
}
