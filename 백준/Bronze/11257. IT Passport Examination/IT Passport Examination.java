import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			int sum = 0;
			
			st = new StringTokenizer(in.readLine());
			String id = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			sum = a+b+c;
			
			System.out.print(id+" "+sum+" ");
			if((double)a < 11 || (double)b < 8 || c < 12 || sum < 55) {
				System.out.println("FAIL");
			}
			else {
				System.out.println("PASS");
			}
		}
	}



}