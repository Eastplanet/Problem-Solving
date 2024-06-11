import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char a = in.readLine().charAt(0);
		if(a == 'M') {
			System.out.println("MatKor");
		}
		else if (a == 'W') {
			System.out.println("WiCys");
		}
		else if(a == 'C') {
			System.out.println("CyKor");
		}
		else if(a=='A') {
			System.out.println("AlKor");
		}
		else {
			System.out.println("$clear");
		}

	}
}