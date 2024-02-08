import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());

		for (int i = 0; i < N; i++) {
			String word = in.readLine();
			for(int j=0;j<word.length();j++) {
				if(word.charAt(j)>='A' && word.charAt(j)<='Z') {
					sb.append((char)(word.charAt(j)-'A'+'a'));
				}
				else {
					sb.append(word.charAt(j));
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}