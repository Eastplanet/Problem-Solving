import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int N, M, K;
	static int[] friends;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][N + 1];

		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				arr[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());

			arr[A][B] = T;
		}
		
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(arr[i][k] == Integer.MAX_VALUE || arr[k][j] == Integer.MAX_VALUE)continue;
					if(arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}
		
		

		K = Integer.parseInt(in.readLine());
		friends = new int[K];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < K; i++) {
			friends[i] = Integer.parseInt(st.nextToken());
		}
		

		
		int min = Integer.MAX_VALUE;
		List<Integer>list = new ArrayList<>();

		// 도시 선택
		for (int i = 1; i <= N; i++) {
			
			int maxLeng = 0;
			
			for(int a=0;a<K;a++) {
				int j = friends[a];
				
				if(i == j)continue;
				if(arr[i][j] == Integer.MAX_VALUE || arr[j][i] == Integer.MAX_VALUE) {
					maxLeng = -1;
					break;
				}
				else {
					maxLeng = Math.max(maxLeng, arr[i][j] + arr[j][i]);
				}
			}
			
			if(maxLeng == -1) {
				continue;
			}
			else {
				if(min > maxLeng) {
					min = maxLeng;
					list.clear();
					list.add(i);
				}
				else if(min == maxLeng) {
					list.add(i);
				}
			}
		}
		
		
		
		Collections.sort(list);
		for (Integer integer : list) {
			System.out.print(integer+" ");
		}
	}
}