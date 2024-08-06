import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		int N = Integer.parseInt(in.readLine());
		for(int i=1;i<=N;i++) {
			System.out.print(i+" ");
			if(i%6 == 0) {
				System.out.print("Go! ");
			}
			else if(i == N) {
				System.out.print("Go! ");
			}
		}
		
	}

}