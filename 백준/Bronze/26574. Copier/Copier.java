import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(in.readLine());
			System.out.println(num+" "+num);
		}
	}
}