import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

	static Map<Integer, Node> map = new HashMap<>();

	static class Node implements Comparable<Node>{
		@Override
		public int compareTo(Node o) {
			return this.pos - o.pos;
		}
		String s;
		int num,pos;
		public Node(String s, int num, int pos) {
			this.s = s;
			this.num = num;
			this.pos = pos;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		List<Node> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			int start = x - r;
			int end = x + r;
			if (map.containsKey(start) || map.containsKey(end)) {
				System.out.println("NO");
				return;
			}
			list.add(new Node("(", i,start));
			list.add(new Node(")", i,end));
		}
		
		Collections.sort(list);
		
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();

		// s1 에 순서대로 담는다.
		for (Node node : list) {
			s1.add(node);
		}

		while (!s1.isEmpty()) {
			Node n = s1.pop();

			if (n.s.equals(")")) {
				s2.add(n);
			}
			// 똑같은 번호의 괄호 짝이 아니라면 실패
			else {
				if(s2.empty()) {
					System.out.println("NO");
					return;
				}
				Node tmp = s2.pop();
				if (!tmp.s.equals(")") || tmp.num != n.num) {
					System.out.println("NO");
					return;
				} 
			}
		}
		
		System.out.println("YES");

	}
}