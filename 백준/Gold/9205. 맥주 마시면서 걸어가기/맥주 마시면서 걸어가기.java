import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int[] pos;

		public Node(int[] pos) {
			this.pos = pos;
		}
	}

	static int getDist(int[] a, int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(in.readLine());

			int[] home = new int[2];
			StringTokenizer st = new StringTokenizer(in.readLine());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());

			int[][] conv = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				conv[i][0] = Integer.parseInt(st.nextToken());
				conv[i][1] = Integer.parseInt(st.nextToken());
			}

			int[] fest = new int[2];
			st = new StringTokenizer(in.readLine());
			fest[0] = Integer.parseInt(st.nextToken());
			fest[1] = Integer.parseInt(st.nextToken());

			Queue<Node> q = new ArrayDeque<>();
			q.add(new Node(home));

			int[] visited = new int[N];
			boolean isHappy = false;
			while (!q.isEmpty()) {
				Node cur = q.poll();

				if (1000 >= getDist(cur.pos, fest)) {
					System.out.println("happy");
					isHappy = true;
					break;
				}

				for (int i = 0; i < N; i++) {
					if (visited[i] == 0) {
						if(cur.pos[0] == conv[i][0] && cur.pos[1] == conv[i][1])continue;
						if (1000 >= getDist(cur.pos, conv[i])) {

							visited[i] = 1;
							q.add(new Node(conv[i]));
						}
					}
				}
			}
			if (isHappy == false) {
				System.out.println("sad");
			}

		}

	}
}