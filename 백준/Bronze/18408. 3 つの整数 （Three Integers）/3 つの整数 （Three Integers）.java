import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(in.readLine());
		
		int one = 0;
		int two = 0;
		
		for(int i=0;i<3;i++) {
			if(Integer.parseInt(st.nextToken()) == 1) {
				one++;
			}
			else {
				two++;
			}
		}
		
		if(one > two) {
			System.out.println(1);
		}
		else {
			System.out.println(2);
		}
	}



}