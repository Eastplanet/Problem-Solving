import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String jae = in.readLine();
		String doc = in.readLine();
		
		if(jae.length() >= doc.length()) {
			System.out.println("go");
		}
		else {
			System.out.println("no");
		}
	}
}