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

	static int N,M;
	static int[][] arr;
	
	static HashMap<String,Integer>map;
	
	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new HashMap<>();
		
		arr = new int[201][201];
		for(int i=0;i<201;i++) {
			for(int j=0;j<201;j++) {
				arr[i][j] = 100_000_000;
			}
		}
		
		int idx = 1;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			String A = st.nextToken();
			if(!map.containsKey(A)) {
				map.put(A, idx++);
			}
			st.nextToken();
			st.nextToken();
			st.nextToken();
			String B = st.nextToken();
			if(!map.containsKey(B)) {
				map.put(B, idx++);
			}
			
			int anum = map.get(A);
			int bnum = map.get(B);
			arr[anum][bnum] = 1;
		}
		
		for(int k=0;k<201;k++) {
			for(int i=0;i<201;i++) {
				for(int j=0;j<201;j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
		
		for(int i=0;i<M;i++) {
			
			st = new StringTokenizer(in.readLine());
			String A = st.nextToken();
			st.nextToken();
			st.nextToken();
			st.nextToken();
			String B = st.nextToken();
			
			int anum = -1;
			if(map.containsKey(A)) {
				anum = map.get(A);
			}
			
			int bnum = -1;
			if(map.containsKey(B)) {
				bnum = map.get(B);
			}
			
			if(anum == -1 || bnum == -1) {
				System.out.println("Pants on Fire");
				continue;
			}
			
			int debug = arr[anum][bnum];
			
			if (arr[anum][bnum] != 100_000_000) {
				System.out.println("Fact");
			}
			else if(arr[bnum][anum] != 100_000_000) {
				System.out.println("Alternative Fact");
			}
			else {
				System.out.println("Pants on Fire");
			}
			
		}
		
	}

}