import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		
		String tmp = in.readLine();
		
		if(tmp.charAt(0)== '5' && tmp.charAt(1) == '5' && tmp.charAt(2) == '5') {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}

	

	
}