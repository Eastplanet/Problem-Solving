import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	static char[] visit;
	static int N;
	static ArrayList<String> result;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(in.readLine());
			result = new ArrayList<>();
			visit = new char[N];
			back(0);

			Collections.sort(result);
			for (String string : result) {
				System.out.println(string);
			}

			System.out.println();
		}
	}

	public static void back(int idx) {

		if (idx == N - 1) {
			ArrayList<Integer> nums = new ArrayList<>();

			int sum = 0;

			nums.add(1);

			for (int i = 0; i < N - 1; i++) {
				if (visit[i] == ' ') {
					int prev = nums.get(nums.size() - 1);
					if (prev > 0) {
						prev *= 10;
						prev += (i + 2);
					} else {
						prev *= 10;
						prev -= (i + 2);
					}
					nums.remove(nums.size() - 1);
					nums.add(prev);
				} else if (visit[i] == '-') {
					nums.add(-1 * (i + 2));
				} else {
					nums.add(i + 2);
				}
			}

			for (int n : nums) {
				sum += n;
			}

			if (sum == 0) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < N - 1; i++) {
					sb.append(i + 1);
					sb.append(visit[i]);
				}
				sb.append(N);

				if (!result.contains(sb.toString())) {
					result.add(sb.toString());
				}
			}

			return;
		}

		for (int i = idx; i < N - 1; i++) {

			visit[i] = '+';
			back(i + 1);
			visit[i] = '-';
			back(i + 1);
			visit[i] = ' ';
			back(i + 1);
		}
	}

}