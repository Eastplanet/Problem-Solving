import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		for(int i=0;i<N;i++) {
			
			int num = Integer.parseInt(in.readLine());
			
			int tmpNum = num;
			if(tmpNum < 0 )tmpNum*=-1;
			
			if(tmpNum%2 == 1) {
				System.out.println(num + " is odd");
			}
			else {
				System.out.println(num + " is even");
			}
		}
	}
}