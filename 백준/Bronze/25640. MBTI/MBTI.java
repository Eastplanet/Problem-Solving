import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		
		String mbti = in.readLine();
		
		int N = Integer.parseInt(in.readLine());
		
		int cnt = 0;
		
		for(int i=0;i<N;i++) {
			String tmp = in.readLine();
			if(tmp.equals(mbti)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	

	
}