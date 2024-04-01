import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String cmd = in.readLine();
			int N = Integer.parseInt(in.readLine());
			String data = in.readLine();
			String substring = data.substring(1, data.length() - 1);
			String[] splits = substring.split(",");

			Deque<Integer> dq = new ArrayDeque<>();
			for (int i = 0; i < N; i++) {
				dq.add(Integer.parseInt(splits[i]));
			}

			boolean isReverse = false;
			boolean isError = false;
			
			for (int i = 0; i < cmd.length(); i++) {
				char c = cmd.charAt(i);
				if (c == 'R') {
					isReverse = isReverse ^ true;
				} else {
					if (dq.isEmpty()) {
						sb.append("error").append("\n");
						isError = true;
						break;
					}
					if (isReverse) {
						dq.pollLast();
					} else {
						dq.pollFirst();
					}
				}
			}
			if(isError) {
				continue;
			}
			sb.append("[");
			while (!dq.isEmpty()) {
				if (isReverse) {
					sb.append(dq.pollLast());
				} else {
					sb.append(dq.pollFirst());
				}
				if (dq.size() != 0) {
					sb.append(",");
				}
			}
			sb.append("]").append("\n");
		}
		System.out.println(sb);
	}
}