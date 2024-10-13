import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		
		
		while(true) {
			double N = Double.parseDouble(in.readLine());
			if(N == 0) {
				break;
			}
			
			double sum = 1;
			sum += N;
			sum += N*N;
			sum += N*N*N;
			sum += N*N*N*N;
			
			System.out.println(String.format("%.2f", sum));
		}
		
		
	}

}