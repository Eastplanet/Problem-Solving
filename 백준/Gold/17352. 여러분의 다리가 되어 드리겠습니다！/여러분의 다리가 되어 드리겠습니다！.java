import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] u;
	
	static int find(int a) {
		if(u[a] < 0)return a;
		return u[a] = find(u[a]);
	}
	
	static void merge(int a,int b) {
		a = find(a);
		b = find(b);
		if(a==b)return;
		
		u[a] += u[b];
		u[b] = a;
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		u = new int[N+1];
		Arrays.fill(u, -1);
		
		for(int i=0;i<N-2;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			merge(a, b);
		}
		
		
		for(int i=2;i<=N;i++) {
			int a = 1;
			int b = i;
			if(find(a) == find(b))continue;
			System.out.println(a+" "+b);
			return;
		}
		
	}
}