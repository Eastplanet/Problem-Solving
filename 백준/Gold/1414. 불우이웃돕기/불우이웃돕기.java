import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] adj;
	static int[] u;

	static int find(int a) {
		if (u[a] < 0)
			return a;
		return u[a] = find(u[a]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return;
		u[a] += u[b];
		u[b] = a;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

		int totalLeng = 0;

		N = Integer.parseInt(in.readLine());
		u = new int[N];
		adj = new int[N][N];
		

		for (int i = 0; i < N; i++) {
			u[i] = -1;
			String tmp = in.readLine();
			for (int j = 0; j < N; j++) {
				char c = tmp.charAt(j);

				adj[i][j] = charToInt(c);

				if (adj[i][j] != 0) {
					totalLeng += charToInt(c);
					pq.add(new int[] { i, j, adj[i][j] });
				}
			}
		}

		int edgeCount = 0;
		int edgeLeng = 0;
		while (!pq.isEmpty() && edgeCount < N - 1) {

			int[] curr = pq.poll();
			int a = curr[0];
			int b = curr[1];

			if (find(a) == find(b)) {
				continue;
			}

			union(a, b);
			edgeLeng += adj[a][b];
			edgeCount++;
		}

		if (edgeCount != N - 1) {
			System.out.println(-1);
		} else {
			System.out.println(totalLeng - edgeLeng);
		}

	}

	static int charToInt(char c) {
		if (c == '0') {
			return 0;
		} else if ('a' <= c && c <= 'z') {
			return c - 'a' + 1;
		} else {
			return c - 'A' + 26 + 1;
		}
	}
}