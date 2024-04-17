import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i=0;i<8;i++) {
			int val = Integer.parseInt(st.nextToken());
			if( !(val == 1 || val == 0)) {
				System.out.println("F");
				return;
			}
		}
		
		System.out.println("S");
		
	}
}