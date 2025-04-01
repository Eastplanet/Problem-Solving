import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int N;
	public static int[] arr;
	public static List<Integer> lis;
	
	public static void main(String[] args) throws Exception {
		
		init();
		
		lis = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			if(lis.isEmpty() || lis.get(lis.size()-1) < arr[i]) {
				lis.add(arr[i]);
			}
			else {
				int idx = findIdx(arr[i]);
				lis.set(idx,arr[i]);
			}
		}
		
		System.out.println(N - lis.size());
		
	}
	
	public static int findIdx(int num) {
		
		int start = 0;
		int end = lis.size()-1;
		
		int ans = Integer.MAX_VALUE;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(lis.get(mid) >= num) {
				ans = Math.min(ans, mid);
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		
		return ans;
	}
	
	public static void init() throws Exception{
		
		N = Integer.parseInt(in.readLine());
		
		arr = new int[N];
		
		st = new StringTokenizer(in.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
}