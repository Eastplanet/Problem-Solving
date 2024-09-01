import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		
		while(true) {
			int n = Integer.parseInt(in.readLine());
			if(n==0) {
				break;
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<=i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}



}