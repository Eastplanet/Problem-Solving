import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		for(int i=0;i<N;i++) {
			String tmp = in.readLine();
			
			char prev = '@';
			for(int j=0;j<tmp.length();j++) {
				if(prev!=tmp.charAt(j)) {
					System.out.print(tmp.charAt(j));
					prev = tmp.charAt(j);
				}
			}
			System.out.println();
		}
	}
	
}