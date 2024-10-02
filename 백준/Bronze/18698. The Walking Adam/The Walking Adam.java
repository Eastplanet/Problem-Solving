import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	static int N;
	
	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			String tmp = in.readLine();
			int sum = 0;
			for(int j=0;j<tmp.length();j++) {
				if(tmp.charAt(j) == 'U')sum++;
				else {
					break;
				}
			}
			System.out.println(sum);
		}
		
		
	}

}