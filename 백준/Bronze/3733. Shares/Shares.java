import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = in.readLine();
			if(str == null) {
				break;
			}
			StringTokenizer st = new StringTokenizer(str);
			int N = Integer.parseInt(st.nextToken())+1;
			int M = Integer.parseInt(st.nextToken());
			
			System.out.println(M/N);
		}
	}
}