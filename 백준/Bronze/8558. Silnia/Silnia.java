import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
	
		
		int N = Integer.parseInt(in.readLine());
		
		int sum = 1;
		
		for(int i=1;i<=N;i++) {
			sum = (sum*i)%10;
		}
		
		System.out.println(sum);
	}
	

}