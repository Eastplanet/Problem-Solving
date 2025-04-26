import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	
	public static void main(String[] args) throws Exception {
		
		int T = Integer.parseInt(in.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			
			for(int i=1;i<=a;i++) {
				for(int j=1;j<=b;j++) {
					for(int k=1;k<=c;k++) {
						if((i % j) == (j % k) && (j%k) == (k % i)) {
							cnt++;
						}
					}
				}
			}
			
			System.out.println(cnt);
			
		}
		
		
	}
	


}