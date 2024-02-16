import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] req = new int[N];
		int yesan;
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int reqSum = 0;
		for(int i=0;i<N;i++) {
			reqSum += req[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(req);
		yesan = Integer.parseInt(in.readLine());
		
		int max = Integer.MIN_VALUE;
		int maxMid = 0;
		
		
		int start = 0;
		int end = yesan;
		int mid = 0;
		
		if(yesan >= reqSum) {
			System.out.println(req[N-1]);
			return;
		}
		
		while(start <= end) {
			mid = (start + end) / 2;
			
			int sum = 0;
			for(int i=0;i<N;i++) {
				if(mid < req[i]) {
					sum += mid;
				}
				else {
					sum += req[i];
				}
			}
			
			
			if(sum > yesan) {
				end = mid - 1;
				continue;
			}
			
			if(max < sum) {
				max = sum;
				maxMid = mid;
			}
			
			start = mid + 1;
		}
		
		System.out.println(maxMid);
	}
}