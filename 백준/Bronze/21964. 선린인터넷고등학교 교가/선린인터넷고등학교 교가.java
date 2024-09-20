import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	

	public static void main(String[] args) throws Exception {

		int N = Integer.parseInt(in.readLine());
		
		String tmp = in.readLine();
		
		if(N <5) {
			System.out.println(tmp);
		}
		else {
			for(int i=N-5;i<N;i++) {
				System.out.print(tmp.charAt(i));
			}
			
		}
		
	}
	
	



}