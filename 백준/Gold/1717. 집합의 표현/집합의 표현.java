import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] disjointSet;
	
	static int find(int a) {
		if(disjointSet[a] < 0 )return a;
		return disjointSet[a] = find(disjointSet[a]);
	}
	
	static void merge(int a,int b) {
		a = find(a);
		b = find(b);
		
		if(a==b)return;
		
		if(disjointSet[a] < disjointSet[b]) {
			disjointSet[a] += disjointSet[b];
			disjointSet[b] = a;
		}
		else {
			disjointSet[b] += disjointSet[a];
			disjointSet[a] = b;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N =Integer.parseInt(st.nextToken());
		int M =Integer.parseInt(st.nextToken());
		
		disjointSet = new int[N+1];
		Arrays.fill(disjointSet, -1);
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(cmd == 0) {
				merge(a, b);
			}
			else {
				if(find(a)==find(b)) {
					sb.append("YES").append("\n");
				}
				else {
					sb.append("NO").append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}