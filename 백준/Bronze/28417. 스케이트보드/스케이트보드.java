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
		
		
		int N = Integer.parseInt(in.readLine());
		
		int sum = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			int[] arr = new int[2];
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			
			int[] arr2 = new int[5];
			arr2[0] = Integer.parseInt(st.nextToken());
			arr2[1] = Integer.parseInt(st.nextToken());
			arr2[2] = Integer.parseInt(st.nextToken());
			arr2[3] = Integer.parseInt(st.nextToken());
			arr2[4] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr2);
			
			int result = arr[1] + arr2[4] + arr2[3];
			sum = Math.max(result, sum);
		}
		System.out.println(sum);
		
		
		
		
		
		
	
	}
	

}