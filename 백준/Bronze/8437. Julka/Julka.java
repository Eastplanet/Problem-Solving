import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger total = new BigInteger(in.readLine());
		BigInteger K = new BigInteger(in.readLine());
		
		BigInteger kl = total.add(K).divide(BigInteger.valueOf(2));
		BigInteger na = total.subtract(K).divide(BigInteger.valueOf(2));
		// kl + na == total
		// kl - na == K
		System.out.println(kl.toString());
		System.out.println(na.toString());

	}
}