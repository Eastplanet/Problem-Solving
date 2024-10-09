import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(in.readLine());
		
		int[] arr = new int[3];
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		arr[0] = A;
		arr[1] = B;
		arr[2] = C;
		
		Arrays.sort(arr);
		
		System.out.println(arr[1]);
	}

}