import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		while(true) {
			String tmp = in.readLine();
			
			if(tmp.equals("END")) {
				break;
			}
			
			for(int i=tmp.length()-1;i>=0;i--) {
				System.out.print(tmp.charAt(i));
			}
			System.out.println();
			
		}
		
	}

}