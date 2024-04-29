import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String s = in.readLine();
		int cnt = 0;
		for(int i=0;i<N;i++) {
			char c = s.charAt(i);
			if(c== 'a' || c=='e' || c=='i' || c=='o'||c=='u') {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}