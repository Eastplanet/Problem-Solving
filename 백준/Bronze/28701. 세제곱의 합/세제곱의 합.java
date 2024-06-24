import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		System.out.println((N+1)*N/2);
		System.out.println((int)Math.pow((N+1)*N/2, 2));
		
		int sum = 0;
		for(int i=1;i<=N;i++) {
			sum += Math.pow(i, 3);
		}
		
		System.out.println(sum);

	}
}