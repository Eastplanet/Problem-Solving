import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	
	public static void main(String[] args) throws Exception {
		
		long[] dp = new long[46];
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i=2;i<=45;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		int T = Integer.parseInt(in.readLine());
		
		while(T-- > 0) {
			int num = Integer.parseInt(in.readLine());
			System.out.println(dp[num]);
		}
		
		
		
	}
	


}