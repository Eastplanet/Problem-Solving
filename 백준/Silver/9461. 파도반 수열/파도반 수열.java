import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while(T-- >0) {
			int N = Integer.parseInt(in.readLine());
			
			long[] arr = new long[N+10];
			
			arr[1] = 1;
			arr[2] = 1;
			arr[3] = 1;
			arr[4] = 2;
			
			for(int i=5;i<=N;i++) {
				arr[i] = arr[i-3]+arr[i-2];
			}
			System.out.println(arr[N]);
		}
	}
}