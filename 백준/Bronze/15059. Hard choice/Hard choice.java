import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(in.readLine());
		
		int[] arr = new int[3];
		for(int i=0;i<3;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine());
		
		int sum = 0;
		int[] tmp = new int[3];
		for(int i=0;i<3;i++) {
			tmp[i] = Integer.parseInt(st.nextToken());
			if(tmp[i] > arr[i])sum += tmp[i]-arr[i];
		}
		
		System.out.println(sum);
	}



}