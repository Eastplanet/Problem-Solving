import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		
		while(true) {
			int N = Integer.parseInt(in.readLine());
			if(N == 0)break;
			
			int start = 1;
			int end = 50;
			while(start <= end) {
				int mid = (start+end)/2;
				System.out.print(mid+" ");
				if(mid == N) {
					break;
				}
				else if(mid < N) {
					start = mid + 1;
				}
				else {
					end = mid - 1;
				}
			}
			
			System.out.println();
		}
		
		
	
	}
	

}