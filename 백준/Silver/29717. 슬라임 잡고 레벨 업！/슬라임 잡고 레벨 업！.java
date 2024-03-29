import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int i=0;i<T;i++) {
			long N = Integer.parseInt(in.readLine());
			long exp = N*(N+1)/2;
			
			long start = 1;
			long end = 1000000000;
			
			long max = 1;
			while(start <= end) {
				long mid = (start+end)/2;
				
				if(check(mid, exp)) {
					start = mid + 1;
					if(max < mid)max = mid;
				}
				else {
					end = mid - 1;
				}
			}
			System.out.println(max);
		}
	}
	
	static boolean check(long lv, long exp) {
		if(exp >= lv*(lv-1))return true;
		else return false;
	}
}