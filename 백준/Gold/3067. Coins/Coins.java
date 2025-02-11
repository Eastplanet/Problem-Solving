import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int N,M;
	public static int[] arr;
	public static int[][] dp;

	public static void main(String[] args) throws Exception {
		
		int T = Integer.parseInt(in.readLine());
		
		while(T-- > 0) {
			input();
			
			// 1번 ~ N번 동전으로 만들어본다.
			for(int i=1;i<=N;i++) {
				
				// 0원 ~ M원까지 만들어본다.
				for(int j=0;j<=M;j++) {
					
					// base case, 0원은 항상 만들 수 있다.
					if(j == 0) {
						dp[i][j] = 1;
						continue;
					}
					
					dp[i][j] = dp[i-1][j];
					
					if(j >= arr[i]) {
						dp[i][j] += dp[i][j-arr[i]];
					}
				}
			}
			
			System.out.println(dp[N][M]);
		}

		
		
	}
	
	public static void input() throws Exception {
		
		N = Integer.parseInt(in.readLine());
		arr = new int[N+1];
		
		st = new StringTokenizer(in.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(in.readLine());
		dp = new int[N+1][M+1];
	}
}