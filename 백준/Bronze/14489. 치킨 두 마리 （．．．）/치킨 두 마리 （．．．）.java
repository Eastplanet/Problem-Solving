import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		StringTokenizer st = new StringTokenizer(in.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int sum = A+B;
		int chicken = Integer.parseInt(in.readLine());
		if(sum - chicken*2 < 0) {
			System.out.println(sum);
		}
		else {
			System.out.println(sum - chicken*2);
		}
	}

}