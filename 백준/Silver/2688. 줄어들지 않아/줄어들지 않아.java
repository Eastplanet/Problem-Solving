import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		
		int T = Integer.parseInt(in.readLine());
		
		long[][] dp = new long[65][10];
		
		for(int i=0;i<10;i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2;i<=64;i++) {
			
			long sum = 0;
			
			for(int j=0;j<10;j++) {
				long tmp = dp[i-1][j];
				
				for(int k=0;k<10;k++) {
					if(k >= j) {
						dp[i][k] += tmp;
					}
				}
			}
		}
		
		for(int i=0;i<T;i++){
			
			int N = Integer.parseInt(in.readLine());
			long sum = 0;
			for(int k=0;k<10;k++) {
				sum += dp[N][k];
			}
			System.out.println(sum);
		}
	}
	

}