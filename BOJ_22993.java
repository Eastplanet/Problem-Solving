package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_22993 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());

		long junwon = Integer.parseInt(st.nextToken());
		long[] arr = new long[N - 1];

		for (int i = 0; i < N - 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		long power = junwon;
		for (int i = 0 ; i < N - 1; i++) {
			
			if(power <= arr[i]) {
				System.out.println("No");
				return;
			}
			
			power += arr[i];
			
		}
		
		System.out.println("Yes");
		
	}
}
