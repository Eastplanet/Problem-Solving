import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		String[] arr = new String[] {
				"Never gonna give you up",
				"Never gonna let you down",
				"Never gonna run around and desert you",
				"Never gonna make you cry",
				"Never gonna say goodbye",
				"Never gonna tell a lie and hurt you",
				"Never gonna stop"
		};
		
		for(int i=0;i<N;i++) {
			String tmp = in.readLine();
			
			boolean ok = false;
			for(String str : arr) {
				if(tmp.equals(str)) {
					ok = true;
				}
			}
			if(!ok) {
				System.out.println("Yes");
				return;
			}
		}
		
		System.out.println("No");

	}

}