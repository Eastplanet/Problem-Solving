import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int N = Integer.parseInt(in.readLine());
			if(N==0)break;
			System.out.println((N*(N+1)/2));
		}

	}
}