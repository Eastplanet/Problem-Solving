import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(in.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			char a = st.nextToken().charAt(0);

			for (int j = 0; j < N; j++) {
				System.out.print(a);
			}
			System.out.println();
		}
	}

}