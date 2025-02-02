import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		
		st = new StringTokenizer(in.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		A *= 7;
		B *= 13;
		
		if(A<B) {
			System.out.println("Petra");
		}
		else if(A > B) {
			System.out.println("Axel");
		}
		else {
			System.out.println("lika");
		}
	}

	

	
}