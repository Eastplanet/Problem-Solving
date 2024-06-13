import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int nm = Integer.parseInt(in.readLine());
		
		if(nm >= 620) {
			System.out.println("Red");
		}
		else if(nm >= 590) {
			System.out.println("Orange");
		}
		else if(nm >= 570) {
			System.out.println("Yellow");
		}
		else if(nm >= 495) {
			System.out.println("Green");
		}
		else if(nm >= 450) {
			System.out.println("Blue");
		}
		else if(nm >= 425) {
			System.out.println("Indigo");
		}
		else if(nm >= 380) {
			System.out.println("Violet");
		}

	}
}