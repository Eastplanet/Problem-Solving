import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		
		int sum = 0;
		
		int N = Integer.parseInt(in.readLine());
		for(int i=1;i<=N;i++) {
			sum += i*i*i;
		}
		
		System.out.println(sum);
	}

	

	
}