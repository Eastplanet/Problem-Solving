import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int N,T;
	public static int[][] arr,dp;
	
	public static void main(String[] args) throws Exception {
		long N = Long.parseLong(in.readLine());
		
		double ans = N/Math.PI;
		double sqAns = Math.sqrt(ans);
		
		System.out.printf("%.9f",2*sqAns*Math.PI);
	}
	
	

	
}