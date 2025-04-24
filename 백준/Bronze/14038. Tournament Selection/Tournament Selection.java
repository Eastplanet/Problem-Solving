import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		
		int cnt = 0;
		for(int i=0;i<6;i++) {
			String tmp = in.readLine();
			if(tmp.charAt(0) == 'W') {
				cnt++;
			}
		}
		
		if(cnt >= 5) {
			System.out.println(1);
		}
		else if(cnt >= 3) {
			System.out.println(2);
		}
		else if(cnt >= 1) {
			System.out.println(3);
		}
		else {
			System.out.println(-1);
		}
	}
	

}