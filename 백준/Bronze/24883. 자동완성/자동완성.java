import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char a= in.readLine().charAt(0);
		
		if(a == 'n' || a == 'N') {
			System.out.println("Naver D2");
		}
		else {
			System.out.println("Naver Whale");
		}
	}
}