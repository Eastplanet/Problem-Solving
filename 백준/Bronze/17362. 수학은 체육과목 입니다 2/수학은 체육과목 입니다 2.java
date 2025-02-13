import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		
		int N = Integer.parseInt(in.readLine());
		N--;
		
		N %= 40;
		
		
		int num = 1;
		int dx = 1;
		
		
		while(N-- > 0) {
			if(num == 5 && dx == 1) {
				dx *= -1;
			}
			if(num == 1 && dx == -1) {
				dx *= -1;
			}
			
			num += dx;
		}
		
		
		System.out.println(num);
	}

	
}