import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
		
		//단순 merge
		u[a] += u[b];
		u[b] = a;
		
		//최적화 merge
		/*
		if(u[a] < u[b]) {
			u[a] += u[b];
			u[b] = a;
		}
		else {
			u[b] += u[a];
			u[a] = b;
		}
		*/
	}
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(in.readLine());
			u = new int[N*2];
			Arrays.fill(u, -1);
			int cnt = 0;
			Map<String,Integer>map = new HashMap<>();
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				if(!map.containsKey(a)) {
					map.put(a, cnt++);
				}
				if(!map.containsKey(b)) {
					map.put(b, cnt++);
				}
				
				merge(map.get(a), map.get(b));
				sb.append(u[find(map.get(a))]* -1).append("\n");
			}
		}
		System.out.println(sb);
	}
}