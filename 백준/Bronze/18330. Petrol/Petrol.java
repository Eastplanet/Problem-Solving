import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		int using = Integer.parseInt(in.readLine());
		int left = Integer.parseInt(in.readLine());
		
		left += 60;
		
		int sum = 0;
		if(left >= using) {
			System.out.println(1500*using);
		}
		else {
			sum += left*1500;
			using -= left;
			
			sum += using*3000;
			
			System.out.println(sum);
		}
		
		
	}



}