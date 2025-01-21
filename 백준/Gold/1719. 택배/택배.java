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

	public static int N, M;
	public static int[][] arr, prev;
	
	public static final int INF = 100_000_000;

	public static void main(String[] args) throws Exception {

		init();

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(arr[i][k] == INF || arr[k][j] == INF || i == j) {
						continue;
					}
					if(arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
						prev[i][j] = k;
					}
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i == j) {
					System.out.print("- ");
					continue;
				}
				System.out.print(findPath(i, j)+" ");
			}
			System.out.println();
		}
	}
	
	public static int findPath(int start, int end) {
		
		int last = prev[start][end];
		
		while(true) {
			if(last == start) {
				return end;
			}
			
			end = last;
			last = prev[start][end];
		}
	}

	public static void init() throws Exception {
		st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][N + 1];
		prev = new int[N + 1][N + 1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				arr[i][j] = INF;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			arr[A][B] = W;
			prev[A][B] = A;

			arr[B][A] = W;
			prev[B][A] = B;
		}

	}

}