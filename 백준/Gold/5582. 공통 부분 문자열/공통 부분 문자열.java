import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	
	public static void main(String[] args) throws Exception {
		
		String A = in.readLine();
		String B = in.readLine();
		
		int[][] dp = new int[A.length()+1][B.length()+1];
		
		int max = 0;
		int maxI = -1;
		int maxJ = -1;
		
		for(int i=0;i<A.length();i++) {
			for(int j=0;j<B.length();j++) {
				char a = A.charAt(i);
				char b = B.charAt(j);
				if(a == b) {
					dp[i+1][j+1] = dp[i][j] + 1;
					if(max < dp[i+1][j+1]) {
						max = dp[i+1][j+1];
						maxI = i+1;
						maxJ = j+1;
					}
				}
			}
		}
		
		System.out.println(max);
	}

}