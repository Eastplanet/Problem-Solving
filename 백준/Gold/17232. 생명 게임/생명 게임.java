import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static int N, M, T, K, a, b;
	public static int[][] arr, sum;

	public static void main(String[] args) throws Exception {

		init();
		for (int t = 0; t < T; t++) {
			
	
			updateSum();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					
					// 현재 좌표를 기준으로  -2K ~ +2K범위를 탐색
					int sum = getRangeSum(j-K, i-K, j+K, i+K);
					if(arr[i][j] == 1) {
						sum--;
					}
					
					
					if(arr[i][j] == 1) {
						if(a <= sum && sum <= b) {
							arr[i][j] = 1;
						}
						else if(sum < a) {
							arr[i][j] = 0;
						}
						else if(sum > b) {
							arr[i][j] = 0;
						}
					}
					else {
						if(a < sum && sum <= b) {
							arr[i][j] = 1;
						}
					}
				}
			}
		}
		
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 1) {
					System.out.print('*');
				}
				else {
					System.out.print('.');
				}
				
			}
			System.out.println();
		}
	}

	// (y1,x1) ~ (y2, x2)구간 내의 누적합을 리턴한다.
	public static int getRangeSum(int x1, int y1, int x2, int y2) {
		
		if(x1 < 0) {
			x1 = 0;
		}
		if(y1 < 0) {
			y1 = 0;
		}
		if(x2 >= M) {
			x2 = M-1;
		}
		if(y2 >= N) {
			y2 = N-1;
		}

		// [y2][x2] - ([y1-1][x2] + [y2][x1-1]) + [y-1][x-1]

		int A = sum[y2][x2];
		int B = y1 != 0 ? sum[y1 - 1][x2] : 0;
		int C = x1 != 0 ? sum[y2][x1 - 1] : 0;
		int D = x1 != 0 && y1 != 0 ? sum[y1 - 1][x1 - 1] : 0;

		return A - (B + C) + D;
	}

	public static void updateSum() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// (i,j) = (i-1,j) + range(0,i,j-1,i);
				int A = i - 1 < 0 ? 0 : sum[i - 1][j];
				int B = j - 1 < 0 ? 0 : getRangeSum(0, i, j - 1, i);
				sum[i][j] = A + B + arr[i][j];
			}
		}
	}

	public static void init() throws Exception {
		st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		sum = new int[N][M];

		st = new StringTokenizer(in.readLine());

		K = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String tmp = in.readLine();

			for (int j = 0; j < M; j++) {
				if (tmp.charAt(j) == '.') {
					arr[i][j] = 0;
				} else {
					arr[i][j] = 1;
				}
			}
		}

	}

}