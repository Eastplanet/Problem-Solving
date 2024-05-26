import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(in.readLine());
		int b = Integer.parseInt(in.readLine());
		
		for(int i=0;i<a;i++) {
			
			for(int j=0;j<b;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}