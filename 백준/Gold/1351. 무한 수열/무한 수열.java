import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.sound.midi.MidiUnavailableException;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static long N,P,Q;
	public static long[][] dp;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(in.readLine());
		
		dp = new long[100][100];
		
		N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		
		
		long ans = topDown(0,0,N);
		
		System.out.println(ans);
		
	}
	
	public static long topDown(int p,int q, long num) {
		long sum = 0;
		
		if(num == 0) {
			return 1;
		}
		else if(dp[p][q] != 0) {
			return dp[p][q];
		}
		
		sum += topDown(p+1, q, num/P);
		sum += topDown(p, q+1, num/Q);
		
		
		return dp[p][q] = sum;
	}
	
	
	

}