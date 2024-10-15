import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		
		int a = Integer.parseInt(in.readLine());
		int b = Integer.parseInt(in.readLine());
		int c = Integer.parseInt(in.readLine());
		int d = Integer.parseInt(in.readLine());
		
		if(a < b && b< c && c<d) {
			System.out.println("Fish Rising");
		}
		else if(d < c && c < b && b < a) {
			System.out.println("Fish Diving");
		}
		else if(a == b && b == c && c == d) {
			System.out.println("Fish At Constant Depth");
		}
		else {
			System.out.println("No Fish");
		}
		
	}

}