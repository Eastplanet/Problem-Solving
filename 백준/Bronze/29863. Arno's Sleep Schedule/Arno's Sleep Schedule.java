import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(in.readLine());
		int B = Integer.parseInt(in.readLine());

		int sum =0;
		if(A >= 20) {
			sum += (24-A);
		}
		else {
			sum -= A;
		}
		sum += B;
		System.out.println(sum);
	}
}