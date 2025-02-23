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
		st = new StringTokenizer(in.readLine());
		int K = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		double d = (W-K)/(double)M;
		if(d < 0) {
			System.out.println(0);
		}
		else if(d != (int)d) {
			System.out.println((int)d + 1);
		}
		else {
			System.out.println((int)d);
		}
	}
	
	

	
}