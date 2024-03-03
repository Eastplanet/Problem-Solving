import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] u;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		u = new int[N];
		Arrays.fill(u, -1);
		
		int save = 0;
		
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(!union(a, b) && save == 0) {
				save = i+1;
			}
		}
		
		System.out.println(save);
	}
	
	static int find(int a) {
		if(u[a] < 0)return a;
		return u[a] = find(u[a]);
	}
	
	static boolean union(int a,int b) {
		a = find(a);
		b = find(b);
		
		if(a==b)return false;
		
		if(u[a] < u[b]) {
			u[a] += u[b];
			u[b] = a;
		}
		else {
			u[b] += u[a];
			u[a] = b;
		}
		
		return true;
	}
}