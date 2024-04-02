import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger[] dp = new BigInteger[10001];
		int N = Integer.parseInt(in.readLine());
		
		dp[0] = BigInteger.valueOf(0);
		dp[1] = BigInteger.valueOf(1);
		for(int i=2;i<=N;i++) {
			dp[i] = dp[i-1].add(dp[i-2]);
		}
		
		System.out.println(dp[N].toString());
	}
}