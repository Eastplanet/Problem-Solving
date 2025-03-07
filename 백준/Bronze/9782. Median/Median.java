import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		
		int c = 1;
		while(true) {
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			if(N==0) {
				break;
			}
			
			int[] arr = new int[N+1];
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			if(N % 2 == 0) {
				System.out.print("Case "+c+": ");
				System.out.printf("%.1f\n",((double)arr[N/2 - 1]+arr[N/2])/2);
			}
			else {
				System.out.print("Case "+c+": ");
				System.out.printf("%.1f\n",(double)arr[N/2]);
			}
			
			c++;
		}
	}
	

	

}