import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 1;
		while(true) {
			String[] tmp = in.readLine().split(" ");
			if(tmp[0].charAt(0) == '0')break;
			
			System.out.println("Case "+N+": Sorting... done!");
			N++;
		}

	}
}