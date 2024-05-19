import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		
		System.out.println("Gnomes:");
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int[] origin = new int[3];;
			for(int j=0;j<3;j++) {
				origin[j] = Integer.parseInt(st.nextToken());
			}
			
			
			boolean ok = true;
			if(origin[0] <= origin[1] && origin[1] <= origin[2]) {ok = true;}
			else if(origin[2] <= origin[1] && origin[1] <= origin[0]) {
				ok = true;
			}
			else {
				ok = false;
			}
			
			
			if(ok) {
				System.out.println("Ordered");
			}
			else {
				System.out.println("Unordered");
			}
			
			
		}
		
		

	}
}