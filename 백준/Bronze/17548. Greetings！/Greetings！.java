import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		String tmp = in.readLine();
		
		System.out.print(tmp.charAt(0));
		for(int i=0;i<(tmp.length()-2)*2;i++) {
			System.out.print(tmp.charAt(1));
		}
		System.out.println(tmp.charAt(tmp.length()-1));
	}

}