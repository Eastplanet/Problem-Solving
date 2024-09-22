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

		int cnt = 1;
		
		while(true) {
			String tmp = in.readLine();
			String tmp2 = in.readLine();
			if(tmp.equals("END"))break;
			
			char[] arr = new char[200];
			char[] arr2 = new char[200];
			
			for(int i=0;i<tmp.length();i++) {
				arr[tmp.charAt(i)]++;
			}
			for(int i=0;i<tmp2.length();i++) {
				arr2[tmp2.charAt(i)]++;
			}
			
			
			boolean flag = false;
			for(int i=0;i<200;i++) {
				if(arr[i] != arr2[i]) {
					flag = true;
				}
			}
			if(flag) {
				System.out.println("Case "+cnt+": different");
			}
			else {
				System.out.println("Case "+cnt+": same");
			}
			
			cnt++;
		}
		
		
	}
	
	



}