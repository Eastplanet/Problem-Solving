import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Main {

	static class Node {
		char c;
		int idx;

		public Node(char c, int idx) {
			super();
			this.c = c;
			this.idx = idx;
		}
	}

	static Stack<Node> s = new Stack<>();
	static Stack<Node> s2 = new Stack<>();
	static ArrayList<int[]> gwalhoList = new ArrayList<>();
	static Set<String> set = new HashSet<>();
	static int[] visited = new int[11];
	static String str;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		str = in.readLine();
		for (int i = 0; i < str.length(); i++) {
			s.add(new Node(str.charAt(i), i));
		}

		// 올바른 괄호 쌍 리스트 gwalhoList 구성
		while (!s.isEmpty()) {
			Node n = s.pop();
			if (n.c == ')') {
				s2.add(n);
			} else if (n.c == '(') {
				Node s2n = s2.pop();
				gwalhoList.add(new int[] { n.idx, s2n.idx });
			}
		}

		powerSet(0);
		List<String> list = new ArrayList<>(set);
		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	static void powerSet(int depth) {

		if (depth == gwalhoList.size()) {

			StringBuffer sb = new StringBuffer(str);

			boolean isDirty = false;
			for (int i = 0; i < depth; i++) {
				if (visited[i] == 1) {

					sb.replace(gwalhoList.get(i)[0], gwalhoList.get(i)[0] + 1, " ");
					sb.replace(gwalhoList.get(i)[1], gwalhoList.get(i)[1] + 1, " ");
					isDirty = true;
				}
			}
			if (isDirty) {
				String string = sb.toString();
				String replaceAll = string.replaceAll(" ", "");
				set.add(replaceAll);
			}
			return;
		}

		visited[depth] = 1;
		powerSet(depth + 1);
		visited[depth] = 0;
		powerSet(depth + 1);

	}
}