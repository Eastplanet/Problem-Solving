import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int N, maxShapeIdx;
	// [idx] 번째 사면체를 만들기 위해 필요한 대포알 개수
	public static int[] ballPerShapes;
	public static int[][] dp;


	public static void main(String[] args) throws Exception {

		input();
		
		for(int i=1;i<=maxShapeIdx;i++) {
			for(int j=1;j<=N;j++) {
				
				// base case
				if(i == 1) {
					dp[i][j] = j;
					continue;
				}
				
				dp[i][j] = dp[i-1][j];
				
				// needCnt 개 만들 수 있다면 만들어보고 갱신한다.
				if(j >= ballPerShapes[i]) {
					// 한개 만드는 경우
					dp[i][j] = Math.min(dp[i][j], dp[i-1][j-ballPerShapes[i]] + 1);			
					// 여러개? 만드는 경우
					dp[i][j] = Math.min(dp[i][j], dp[i][j-ballPerShapes[i]] + 1); 
				}
				
			}
		}
		
		System.out.println(dp[maxShapeIdx][N]);
		
	}

	public static void input() throws Exception {
		N = Integer.parseInt(in.readLine());
		
		ballPerShapes = new int[1000];
		
		int cnt = 0;
		
		// 한변의 길이가 N일때까지 삼각형 크기를 구함
		int idx = 1;
		while(cnt <= N) {
			ballPerShapes[idx] = cnt = cnt + idx;
			idx++;
		}
		
		// 임의로 적당히 잡아놓은 1000을 쓰면 비효율적, N개의 포탄을 넘게 쓸 수 없으니 N을 넘지않도록 idx 조정 
		idx--;
		maxShapeIdx = idx;
		
		// 해당 삼각형들로 1번째 사면체를 만들때 필요한 포탄 수를 누적합으로 구함
		// N개의 포탄을 넘게 쓸 수 없으니 idx 조정
		for(int i=1;i<=maxShapeIdx;i++) {
			ballPerShapes[i] = ballPerShapes[i-1] + ballPerShapes[i];
			
			if(ballPerShapes[i] > N) {
				maxShapeIdx = i-1;
				break;
			}
		}
		
		dp = new int[maxShapeIdx+1][N+1];
	}

}