import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	static int N;
	
	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		H= Math.max(N-H, H);
		V= Math.max(N-V, V);
		
		System.out.println(H*V*4);
	}

}