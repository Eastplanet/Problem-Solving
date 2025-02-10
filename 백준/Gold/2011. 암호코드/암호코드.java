import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		String arr = in.readLine();

		int[] dp = new int[arr.length()];

		if(isInNum('1', '9', arr.charAt(0))) {
			dp[0] = 1;
		}

		for (int i = 1; i < arr.length(); i++) {

			if(isInNum('1', '9', arr.charAt(i))) {
				if (i >= 1) {
					dp[i] = (dp[i] % 1000000 + dp[i - 1] % 1000000) % 1000000;
				} else {
					dp[i] = (dp[i] % 1000000 + 1) % 1000000;
				}
			}

			if((arr.charAt(i-1) == '1' && isInNum('0', '9', arr.charAt(i))) ||
			   (arr.charAt(i-1) == '2' && isInNum('0', '6', arr.charAt(i)))) {
				
				if (i >= 2) {
					dp[i] = (dp[i] % 1000000 + dp[i - 2] % 1000000) % 1000000;
				}
				else {
					dp[i] = (dp[i] % 1000000 + 1) % 1000000;
				}
			}

		}

		System.out.println(dp[arr.length() - 1]);

	}
	
	public static boolean isInNum(char start, char end, char check) {
		return start <= check && check <= end;
	}

}