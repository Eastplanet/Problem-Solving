import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int N;
	public static int[][] dp,arr;
	
	public static void main(String[] args) throws Exception {
		
		init();
		
		int result = DP(0, 0, 1);
		
		System.out.println(result + 1);
	}
	
	public static int DP(int idx, int price, int bit) {
		
		if(dp[idx][bit] != 0) {
			return dp[idx][bit];
		}
		
		for(int i=0;i<N;i++) {
			// 이미 방문했다면
			if(((1<<i) & bit) != 0){
				continue;
			}
			// 다음 방문의 가격이 더 높거나 같다면
			if(price <= arr[idx][i]) {
				dp[idx][bit] = Math.max(dp[idx][bit], DP(i,arr[idx][i], (1<<i) | bit) +1);
			}
		}
		
		return dp[idx][bit];
	}
	
	public static void init() throws Exception{
		N = Integer.parseInt(in.readLine());
		
		arr = new int[N][N];
		dp = new int[N][2<<N];
		
		for(int i=0;i<N;i++) {
			String tmp = in.readLine();
			
			for(int j=0;j<N;j++) {
				arr[i][j] = tmp.charAt(j)-'0';
			}
		}
		
		
	}
}