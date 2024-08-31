import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int[][] adj = new int[52][52];

	public static void main(String[] args) throws Exception {

		int limit = Integer.parseInt(in.readLine());
		int speed = Integer.parseInt(in.readLine());
		
		if(limit >= speed) {
			System.out.println("Congratulations, you are within the speed limit!");
		}
		else if(speed - limit >= 31) {
			System.out.println("You are speeding and your fine is $500.");
		}
		else if(speed - limit >= 21) {
			System.out.println("You are speeding and your fine is $270.");
		}
		else {
			System.out.println("You are speeding and your fine is $100.");
		}
	}



}