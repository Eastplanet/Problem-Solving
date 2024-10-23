import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
	
		
		
		while(true) {
			String tmp = in.readLine();
			if(tmp.equals("CU")) {
				System.out.println("see you");
			}
			else if(tmp.equals(":-)")) {
				System.out.println("I’m happy");
			}
			else if(tmp.equals(":-(")) {
				System.out.println("I’m unhappy");
			}
			else if(tmp.equals(";-)")) {
				System.out.println("wink");
			}
			else if(tmp.equals(":-P")) {
				System.out.println("stick out my tongue");
			}
			else if(tmp.equals("(~.~)")) {
				System.out.println("sleepy");
			}
			else if(tmp.equals("TA")) {
				System.out.println("totally awesome");
			}
			else if(tmp.equals("CCC")) {
				System.out.println("Canadian Computing Competition");
			}
			else if(tmp.equals("CUZ")) {
				System.out.println("because");
			}
			else if(tmp.equals("TY")) {
				System.out.println("thank-you");
			}
			else if(tmp.equals("YW")) {
				System.out.println("you’re welcome");
			}
			else if(tmp.equals("TTYL")){
				System.out.println("talk to you later");
				break;
			}
			else {
				System.out.println(tmp);
			}
		}
	}
	

}