import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int sum = 0;
		for(int i=0;i<N;i++) {
			sum += Integer.parseInt(in.readLine());
		}
		System.out.println(sum);
	}
}