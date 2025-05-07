import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		
		double k = Double.parseDouble(in.readLine());
		
		k = 25 + k*0.01;
		if(k < 100) {
			System.out.println("100.00");
		}
		else if(k > 2000) {
			System.out.println("2000.00");
		}
		else {
			System.out.printf("%.2f",k);
		}
		
	}
	



}