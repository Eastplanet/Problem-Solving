import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int start = 0;
		int end = N-1;
		
		int min = Integer.MAX_VALUE;
		int minIdx1 = -1;
		int minIdx2 = -1;
		while(start < end) {
			int val = arr[start]+arr[end];
			
			if(Math.abs(val) < min) {
				min = Math.abs(val);
				minIdx1 = start;
				minIdx2 = end;
			}
			
			if(val > 0) {
				end--;
			}
			else {
				start++;
			}
		}
		
		System.out.println(arr[minIdx1] +" "+arr[minIdx2]);
	}
}