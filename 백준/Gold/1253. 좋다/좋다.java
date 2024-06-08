import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int count = 0;

		for (int i = 0; i < N; i++) {

			// -3 -2 -1
			int start = 0;
			int end = N-1;
			
			if(start == i)start ++;
			if(end == i)end--;
			
			while (start < end) {
				
				long val = arr[end] + arr[start];
				
				if (val < arr[i]) {
					start++; 
					if(start == i) {
						start++;
					}
				} else if (val > arr[i]) {
					end--;
					if(end == i) {
						end--;
					}
				} else {
					count++;
					break;
				}
			}
		}

		System.out.println(count);

	}
}