import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		for(int i=1;i<=N;i++) {
			String tmp = in.readLine();
			sb.append(i+". "+tmp).append("\n");
		}
		System.out.println(sb);
	}
}