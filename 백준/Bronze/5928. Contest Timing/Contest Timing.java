import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int[][] adj = new int[52][52];

	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(in.readLine());
		int D = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int min = M + H*60 + D*24*60;
		
		int start = 11 + 11*60 + 11*24*60;
		if(min < start)System.out.println(-1);
		else {
			System.out.println(min - start);
		}
		
	}



}