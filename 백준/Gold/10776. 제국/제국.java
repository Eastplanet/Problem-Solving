import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	// K: 뗏목 두께, N 노드 수, M 엣지 수
	public static int N, M, K, start, end;
	public static List<Edge>[] adj;
	public static int[] visited;

	public static void main(String[] args) throws Exception {
		init();

		PriorityQueue<Node> pq = new PriorityQueue<>((Node o1, Node o2) -> {
			return o1.time - o2.time;
		});

		pq.add(new Node(start, 0, 0));
		visited[start] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if (curr.num == end) {
				System.out.println(curr.time);
				return;
			}

			for (Edge edge : adj[curr.num]) {
				int next = edge.end;

				// 이전에 이미 더 낮게 뗏목이 깎여서 온적이 있다면 스킵
				if (visited[next] <= curr.height + edge.trim || curr.height + edge.trim >= K) {
					continue;
				}
				
				visited[curr.num] = curr.height + edge.trim;

				pq.add(new Node(next, curr.time + edge.time, curr.height + edge.trim));
			}
		}

		System.out.println(-1);
	}

	public static void init() throws Exception {
		st = new StringTokenizer(in.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];
		visited = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
			visited[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			adj[A].add(new Edge(B, t, h));
			adj[B].add(new Edge(A, t, h));
		}

		st = new StringTokenizer(in.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

	}

	public static class Node {
		int num, time, height;

		public Node(int num, int time, int height) {
			this.num = num;
			this.time = time;
			this.height = height;
		}
	}

	public static class Edge {
		int end, time, trim;

		public Edge(int end, int time, int trim) {
			this.end = end;
			this.time = time;
			this.trim = trim;
		}
	}
}