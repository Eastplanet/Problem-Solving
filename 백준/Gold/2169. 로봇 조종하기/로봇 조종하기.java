import java.io.*;
import java.lang.*;
import java.util.*;

class Main {

	public static int N,M;
	public static long[][] arr;
	public static long[][][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new long[N][M];

		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++){
				arr[i][j] = Long.parseLong(st.nextToken());
			}
		}

		dp = new long[N][M][3];
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				for(int k=0;k<3;k++){
					dp[i][j][k] = Integer.MIN_VALUE;
				}
			}
		}

		dp[0][0][0] = arr[0][0];
		dp[0][0][1] = arr[0][0];
		// dp[0][0][0] = arr[0][0] ;
		// dp[0][0][1] = arr[0][0] ;

		for(int i=0;i<N;i++){
			
			for(int j=0;j<M;j++){

				//위에서 아래로 진행
				if(i > 0){
					// k = 0 위에서 내려옴, k=1 왼쪽에서옴, k=2 오른쪽에서옴
					// 위에서 내려오는 것은 어디에서 온 것인지 상관이 없음
					for(int k=0;k<3;k++){
						if(dp[i-1][j][k] != Integer.MIN_VALUE){
							dp[i][j][0] = Math.max(dp[i][j][0], dp[i-1][j][k] + arr[i][j]);
						}
					}
				}
				
				// 왼쪽에서 오른쪽으로 진행
				if(j > 0){
					for(int k=0;k<3;k++){
						// 왼쪽에서 오기 위해서는 이전에 오른쪽에서 온 것이면 안됨
						if(k == 2){
							continue;
						}
						
						if(dp[i][j-1][k] != Integer.MIN_VALUE){
							dp[i][j][1] = Math.max(dp[i][j][1], dp[i][j-1][k] + arr[i][j]);
						}
					}
				}
			}

			for(int j=0;j<M;j++){
				// 오른쪽에서 왼쪽으로 진행
				int rightIdx = M - 1 - j;
				// System.out.println("right :" + rightIdx);
				if(rightIdx < M-1){
					// System.out.println("들어왔음!");
					
					for(int k=0;k<3;k++){
						// 오른쪽에서 오기 위해서는 이전에 왼쪽에서 온것이면 안됨
						if(k == 1){
							continue;
						}
						if(dp[i][rightIdx+1][k] != Integer.MIN_VALUE){
								dp[i][rightIdx][2] = Math.max(dp[i][rightIdx][2], dp[i][rightIdx+1][k] + arr[i][rightIdx]);
							// System.out.println("i는" + i + "위치! : " + rightIdx + "결과  " + dp[i][rightIdx][2]);
							}
					}
					
				}
			}
			
		}

		

		long result = dp[N-1][M-1][0];
		result = Math.max(result, dp[N-1][M-1][1]);
		result = Math.max(result, dp[N-1][M-1][2]);
		System.out.println(result);
		
	}
}