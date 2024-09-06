import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		int a = Integer.parseInt(in.readLine());
		int b = Integer.parseInt(in.readLine());
		int c = Integer.parseInt(in.readLine());
		int d = Integer.parseInt(in.readLine());
		int e = Integer.parseInt(in.readLine());
		int f = Integer.parseInt(in.readLine());
		
		int sum = a*3-d*3 + b*2 - e*2 + c-f;
		
		if(sum > 0) {
			System.out.println("A");
		}
		else if(sum < 0) {
			System.out.println("B");
		}
		else {
			System.out.println("T");
		}
	}



}