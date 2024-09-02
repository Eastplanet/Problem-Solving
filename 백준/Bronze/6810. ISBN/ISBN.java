import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		StringBuilder start = new StringBuilder("9780921418");
		start.append(in.readLine());
		start.append(in.readLine());
		start.append(in.readLine());
		
		String num = start.toString();
		int sum = 0;
		int toggle = 1;
		for(int i=0;i<13;i++) {
			sum += toggle * ((int)(num.charAt(i)-'0'));
			if(toggle == 1)toggle =3;
			else toggle = 1;
		}
		System.out.print("The 1-3-sum is ");
		System.out.println(sum);
	}



}