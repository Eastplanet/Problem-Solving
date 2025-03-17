import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int N;
	public static Pos[] arr;
	
	public static void main(String[] args) throws Exception {
		
		init();
		
        Arrays.sort(arr);
        
		long sum = 0;
		
		int prev_start = arr[0].start;
		int prev_end = arr[0].end;
		
		sum += prev_end - prev_start;
		
		for(int i=1;i<N;i++) {
			
			Pos next = arr[i];
			
			if(prev_start <= next.start && next.start <= prev_end) {
				if(next.end < prev_end) {
					continue;
				}
				sum += next.end - prev_end;
			}
			else {
				sum += next.end - next.start;
			}
			
			prev_start = next.start;
			prev_end = next.end;
		}
		
		System.out.println(sum);
	}
	
	
	public static void init() throws Exception{
		
		N = Integer.parseInt(in.readLine());
		
		arr = new Pos[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Pos pos = new Pos(a,b);
			arr[i] = pos;
		}
	}
	
	public static class Pos implements Comparable<Pos>{
		int start,end;
		public Pos(int start,int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Pos o) {
			if(this.start != o.start) {
				return this.start - o.start;
			}
			return this.end - o.end;
		}
	}
	

	

}