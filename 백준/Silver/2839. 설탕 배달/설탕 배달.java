import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int count = 0;
		
		int cal = N/5;
		N %= 5;
		
		while(N > 0) {
			
			if(cal < 0 )break;
			
			if(N%3 == 0) {
				cal += N/3;
				N %= 3;
				break;
			}
			
			if(cal >= 0) {
				cal--;
				N=N+5;
			}
			
		}
		
		if(N == 0)System.out.println(cal);
		else System.out.println("-1");
	}
}