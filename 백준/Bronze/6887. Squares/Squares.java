import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		int N = Integer.parseInt(in.readLine());
		
		int max = 0;
		for(int i=1;i<=N;i++) {
			if(i*i <= N)max = i;
			else {
				break;
			}
		}
		System.out.println("The largest square has side length "+max+".");
	}



}