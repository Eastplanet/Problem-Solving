import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String tmp = in.readLine();
		
		if(tmp.charAt(0)=='N') {
			System.out.println("North London Collegiate School");
		}
		else if(tmp.charAt(0)=='B') {
		System.out.println("Branksome Hall Asia");	
		}
		else if(tmp.charAt(0)=='K') {
			System.out.println("Korea International School");
		}
		else {
			System.out.println("St. Johnsbury Academy");
		}
		
	}
}