import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		String tmp = in.readLine();
		BigInteger a = new BigInteger(tmp);
		
		int qwe = Integer.parseInt(tmp);
		
		if(qwe == 0) {
			System.out.println(1);
			return;
		}
		for(int i=qwe-1;i>=1;i--) {
			a = a.multiply(BigInteger.valueOf(i));
		}
		
		
		System.out.println(a);
	}
}