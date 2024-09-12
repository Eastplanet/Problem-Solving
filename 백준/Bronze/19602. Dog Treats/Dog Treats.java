import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		int S = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		int L = Integer.parseInt(in.readLine());
		
		if(S+2*M+3*L >= 10) {
			System.out.println("happy");
		}
		else {
			System.out.println("sad");
		}
	}



}