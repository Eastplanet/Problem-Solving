import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		
		int T = Integer.parseInt(in.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(in.readLine());
			
			int[] arr = new int[5];
			
			for(int i=0;i<5;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			if(arr[3] - arr[1] >= 4) {
				System.out.println("KIN");
			}
			else {
				System.out.println((arr[1]+arr[2]+arr[3]));
			}
		}
		
	}
	
}