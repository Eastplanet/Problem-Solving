import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		BigInteger a = new BigInteger(in.readLine());
		BigInteger b = new BigInteger(in.readLine());
		BigInteger c = new BigInteger(in.readLine());
		
		System.out.println((b.subtract(c)).divide(a));
	}

}