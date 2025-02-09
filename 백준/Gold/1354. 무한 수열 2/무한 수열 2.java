import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static long N,P,Q,X,Y;
	public static HashMap<Long, Long> map;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(in.readLine());
		
		map = new HashMap<>();
		
		N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		X = Long.parseLong(st.nextToken());
		Y = Long.parseLong(st.nextToken());
		
		
		long ans = topDown(N);		
		System.out.println(ans);
		
	}
	
	public static long topDown(long num) {
		long sum = 0;
		
		if(num <= 0) {
			return 1;
		}
		else if(map.containsKey(num)) {
			return map.get(num);
		}
		
		sum += topDown(num/P - X);
		sum += topDown(num/Q - Y);
		
		
		map.put(num, sum);
		return map.get(num);
	}
	
	
	

}