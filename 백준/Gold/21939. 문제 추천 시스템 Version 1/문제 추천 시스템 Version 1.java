import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

	static class Problem {
		int num, diff;
		boolean isSolved;

		public Problem(int num, int diff) {
			this.num = num;
			this.diff = diff;
		}
	}

	static PriorityQueue<Problem> min = new PriorityQueue<>((p1, p2) -> {
		if (p1.diff == p2.diff) {
			return p1.num - p2.num;
		}
		return p1.diff - p2.diff;
	});

	static PriorityQueue<Problem> max = new PriorityQueue<>((p1, p2) -> {
		if (p1.diff == p2.diff) {
			return p2.num - p1.num;
		}
		return p2.diff - p1.diff;
	});

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		// proCount[i] = 0 i번 문제가 없다 [i] = 1 i번 문제가 있다.
		Problem[] proCount = new Problem[100001];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int num = Integer.parseInt(st.nextToken());
			int diff = Integer.parseInt(st.nextToken());

			proCount[num] = new Problem(num, diff);
			min.add(proCount[num]);
			max.add(proCount[num]);
		}

		int P = Integer.parseInt(in.readLine());
		for (int i = 0; i < P; i++) {

			StringTokenizer st = new StringTokenizer(in.readLine());
			String cmd = st.nextToken();

			if ("add".equals(cmd)) {
				int num = Integer.parseInt(st.nextToken());
				int diff = Integer.parseInt(st.nextToken());

				proCount[num] = new Problem(num, diff);
				min.add(proCount[num]);
				max.add(proCount[num]);
			} else if ("recommend".equals(cmd)) {
				int option = Integer.parseInt(st.nextToken());
				if (option == 1) {
					while (true) {
						Problem problem = max.poll();
						if (!problem.isSolved) {
							sb.append(problem.num).append("\n");
							max.add(problem);
							break;
						}
					}
				} else {
					while (true) {
						Problem problem = min.poll();
						if (!problem.isSolved) {
							sb.append(problem.num).append("\n");
							min.add(problem);
							break;
						}
					}
				}
			} else if ("solved".equals(cmd)) {
				int num = Integer.parseInt(st.nextToken());
				proCount[num].isSolved = true;
			}
		}

		System.out.println(sb);

	}

}