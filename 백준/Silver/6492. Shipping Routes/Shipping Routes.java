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
	

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(in.readLine());
		
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(in.readLine());
			
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			
			Map<String,Integer> map = new HashMap<>();
			
			st = new StringTokenizer(in.readLine());
			for(int i=0;i<M;i++) {
				map.put(st.nextToken(),i);
			}
			
			int[][] adj = new int[M+1][M+1];
			
			for(int i=0;i<M;i++)
				for(int j=0;j<M;j++)
					adj[i][j] = 100_000;
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(in.readLine());
				int a = map.get(st.nextToken());
				int b = map.get(st.nextToken());
				
				adj[a][b] = 1;
				adj[b][a] = 1;
			}
			
			for(int k=0;k<M;k++) {
				for(int i=0;i<M;i++) {
					for(int j=0;j<M;j++) {
						adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
					}
				}
			}
			
			System.out.println("DATA SET "+t);
			System.out.println();
			for(int i=0;i<P;i++) {
				st = new StringTokenizer(in.readLine());
				int val = Integer.parseInt(st.nextToken());
				int a = map.get(st.nextToken());
				int b = map.get(st.nextToken());
				if(adj[a][b] == 100_000) {
					System.out.println("NO SHIPMENT POSSIBLE");
				}
				else {
					System.out.println("$"+val*adj[a][b]*100);
				}
			}
			System.out.println();
		}
		
	}
	
	



}