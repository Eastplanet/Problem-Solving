import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.print.DocFlavor.STRING;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	static int xs,ys,xe,ye;
	
	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(in.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		if(a==b && b== c) {
			System.out.println("*");
		}
		
		else if(a != b && b == c) {
			System.out.println("A");
		}
		else if(b != c && a == c) {
			System.out.println("B");
		}
		else {
			System.out.println("C");
		}
	}
	
	



}