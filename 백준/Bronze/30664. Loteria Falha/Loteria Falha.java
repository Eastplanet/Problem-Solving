import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			BigInteger N = new BigInteger(in.readLine());
			if(N.equals(new BigInteger("0")))break;
			if(N.mod(new BigInteger("42")).equals(new BigInteger("0"))) {
				System.out.println("PREMIADO");
			}

			else {
				System.out.println("TENTE NOVAMENTE");
			}
					
		}
	}

}