import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int V,E;
	static int[][] adj;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adj = new int[V+1][V+1];
		for(int i=0;i<V+1;i++) {
			for(int j=0;j<V+1;j++) {
				adj[i][j] = 10000000;
			}
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(in.readLine());
			int s  = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[s][e] = c;
		}
		
		for(int k=1;k<=V;k++) {
			for(int i=1;i<=V;i++) {
				for(int j=1;j<=V;j++) {
					int val = adj[i][k] + adj[k][j];
					
					if(adj[i][j] > val) {
						adj[i][j] = val;
					}
				}
			}
		}
		
		int min = 10000000;
		
		for(int i=1;i<=V;i++) {
			for(int j=1;j<=V;j++) {
				min = Math.min(adj[i][j]+adj[j][i], min);
			}
		}
		
		if(min == 10000000) {
			System.out.println(-1);
		}
		else {
			System.out.println(min);			
		}
		

	}
}