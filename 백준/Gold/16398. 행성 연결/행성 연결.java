import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge> {

		int dist, start, end;

		@Override
		public int compareTo(Edge o) {
			return this.dist - o.dist;
		}

		public Edge(int start, int end, int dist) {
			super();
			this.dist = dist;
			this.start = start;
			this.end = end;
		}

	}

	static int[] u;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());

		int[][] arr = new int[N][N];

		u = new int[N];
		Arrays.fill(u, -1);

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				pq.add(new Edge(i, j, arr[i][j]));
			}
		}

		int edgesCount = 0;
		long edgeDistSum = 0;
		while (edgesCount != N - 1) {
			Edge curr = pq.poll();

			boolean isNotCycle = union(curr.start, curr.end);
			if (isNotCycle) {
				edgesCount++;
				edgeDistSum += curr.dist;
			}
		}
		
		System.out.println(edgeDistSum);
	}

	public static int find(int a) {
		if (u[a] < 0)
			return a;

		return u[a] = find(u[a]);
	}

	public static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return false;
		
		
		if (u[a] < u[b]) {
			u[a] += u[b];
			u[b] = a;
		} else {
			u[b] += u[a];
			u[a] = b;
		}

		return true;
	}
}