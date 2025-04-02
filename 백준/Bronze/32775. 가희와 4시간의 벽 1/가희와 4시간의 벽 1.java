import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	
	public static void main(String[] args) throws Exception {
		
		int S = Integer.parseInt(in.readLine());
		int F = Integer.parseInt(in.readLine());
		
		if(S <= F) {
			System.out.println("high speed rail");
		}
		else {
			System.out.println("flight");
		}
	}

}