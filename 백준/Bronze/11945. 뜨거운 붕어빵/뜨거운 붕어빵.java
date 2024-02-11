import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			String tmp = in.readLine();
			for(int j=M-1;j>=0;j--) {
				System.out.print(tmp.charAt(j));
			}
			System.out.println();
		}
		
	}
}