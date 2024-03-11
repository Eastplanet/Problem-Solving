import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(in.readLine());
		int b = Integer.parseInt(in.readLine());
		int c = Integer.parseInt(in.readLine());
		
		if(a+b+c != 180) {
			System.out.println("Error");
		}
		else if(a==b && b == c) {
			System.out.println("Equilateral");
		}
		else if(a!=b && b != c && a != c) {
			System.out.println("Scalene");
		}
		else {
			System.out.println("Isosceles");
		}
	}
}