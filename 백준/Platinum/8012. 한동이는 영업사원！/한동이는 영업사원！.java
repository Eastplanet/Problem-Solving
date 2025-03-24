import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int N, M;
	public static List<Integer>[] adj;
	public static int[] level, sequence;
	public static int[][] p;
	public static final int MAX_LEVEL = 20;

	public static void main(String[] args) throws Exception {
		init();

		// level마킹
		markLevel();

		// p 배열을 만든다.
		makeP();

		// m 목록만큼 순회
		long result = 0;

		for (int i = 1; i < M; i++) {
			int prev = sequence[i - 1];
			int curr = sequence[i];

			// prev ~ curr 까지 방문하는 비용은
			// prev와 curr의 LCA를 찾은 뒤, prev ~ LCA + LCA ~ curr의 거리이다.
			int lca = findLCA(prev, curr);
			result += (Math.abs(level[lca] - level[prev]));
			result += (Math.abs(level[lca] - level[curr]));
		}
		
		System.out.println(result);
	}

	public static int findLCA(int a, int b) {


		if (level[a] != level[b]) {

			if (level[a] < level[b]) {
				int tmp = a;
				a = b;
				b = tmp;
			}

			int diff = level[a] - level[b];

			for (int i = 0; diff > 0; i++) {
				if (diff % 2 == 1) {
					a = p[a][i];
				}
				diff = diff >> 1;
			}
		}

		if (a == b) {
			return a;
		}

		for (int i = MAX_LEVEL - 1; i >= 0; i--) {
			if(p[a][i] != 0 && p[a][i] != p[b][i]) {
				a = p[a][i];
				b = p[b][i];
			}
		}
		
		return p[a][0];
	}

	public static void makeP() {
		for (int i = 1; i < MAX_LEVEL; i++) {
			for (int j = 1; j <= N; j++) {
				p[j][i] = p[p[j][i-1]][i-1];
			}
		}
	}

	public static void markLevel() {

		Queue<Integer> q = new ArrayDeque<>();
		level[1] = 1;
		q.add(1);
		
		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int next : adj[curr]) {
				if (level[next] != 0) {
					continue;
				}

				level[next] = level[curr] + 1;
				p[next][0] = curr;
				q.add(next);
			}
		}
	}

	public static void init() throws Exception {
		N = Integer.parseInt(in.readLine());
		
		adj = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}

		p = new int[N + 1][MAX_LEVEL];

		level = new int[N + 1];
		M = Integer.parseInt(in.readLine());
		
		sequence = new int[M];
		for (int i = 0; i < M; i++) {
			sequence[i] = Integer.parseInt(in.readLine());
		}
	}

}