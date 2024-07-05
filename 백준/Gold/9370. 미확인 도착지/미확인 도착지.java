import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	static List<Edge>[] adj;
	static List<Integer> target;
	static int nodeCnt, edgeCnt, targetCnt;
	static int start, g, h;
	static int[] dist;
	static int[] isTarget;
	static int[] isNotMin;

	static List<Integer> candidates;

	static int smellRoadLength;

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {

			input();
			PriorityQueue<Item> pq = new PriorityQueue<>();
			pq.add(new Item(start, 0));
			int[] visited = new int[nodeCnt + 1];

			while (!pq.isEmpty()) {
				Item curr = pq.poll();
				
				if (visited[curr.num] == 1)continue;
				visited[curr.num] = 1;
				
				if (isTarget[curr.num] == 1) {
					if (curr.length % 2 != 0) {
						candidates.add(curr.num);
					}
				}
				
				for(Edge edge : adj[curr.num]) {
					if(visited[edge.end] == 1)continue;
					pq.add(new Item(edge.end,curr.length + edge.weight));
				}
			}
			
			Collections.sort(candidates);
			for(Integer i : candidates)System.out.print(i + " ");
			System.out.println();

		}

	}

	static int retLength(int length) {
		if (length % 2 == 0)
			return length / 2;
		else
			return (length + 1) / 2;
	}

	static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(in.readLine());
		nodeCnt = Integer.parseInt(st.nextToken());
		edgeCnt = Integer.parseInt(st.nextToken());
		targetCnt = Integer.parseInt(st.nextToken());

		adj = new ArrayList[nodeCnt + 1];
		for (int i = 0; i <= nodeCnt; i++)
			adj[i] = new ArrayList<>();

		st = new StringTokenizer(in.readLine());
		start = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		dist = new int[nodeCnt + 1];
		isTarget = new int[nodeCnt + 1];
		isNotMin = new int[nodeCnt + 1];

		for (int i = 0; i < edgeCnt; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			c *= 2;
			// 냄새 도로 특정
			if ((a == g && b == h) || (b == g && a == h)) {
				c--;
				smellRoadLength = c;
			}

			adj[a].add(new Edge(a, b, c));
			adj[b].add(new Edge(b, a, c));

		}

		target = new ArrayList<>();
		for (int i = 0; i < targetCnt; i++) {
			int num = Integer.parseInt(in.readLine());
			target.add(num);
			isTarget[num] = 1;
		}

		candidates = new ArrayList<Integer>();
	}

	static class Item implements Comparable<Item>{
		int num, length;

		public Item(int num, int length) {
			this.length = length;
			this.num = num;
		}
		
		@Override
		public int compareTo(Item o) {
			return this.length - o.length;
		}

		@Override
		public String toString() {
			return "Item [num=" + num + ", length=" + length + "]";
		}
		
	}

	static class Edge {
		int start, end, weight;
		public Edge(int start, int end, int weight) {
			this.end = end;
			this.start = start;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}
		
	}

}
