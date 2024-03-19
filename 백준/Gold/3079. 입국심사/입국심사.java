import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	static int N,M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		long min = Long.MAX_VALUE;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(in.readLine());
			if(min > arr[i])min = arr[i];
		}
		
		long start = 0;
		long end = min*M;
		
		long minTime = Long.MAX_VALUE;
		
		while(start<=end) {
			
			long mid = (start+end)/2;
			
			if(canPass(mid)) {
				if(minTime > mid) {
					minTime = mid;
				}
				
				end = mid-1;
			}
			else {
				start = mid+1;
			}
		}
		System.out.println(minTime);
		
	}
	
	static boolean canPass(long time) {
		
		long cnt = 0;
		for(int i=0;i<N;i++) {
			cnt += time/arr[i];
		}
		
		if(cnt >= M)return true;
		else return false;
	}
}