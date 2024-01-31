package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_no4 {

	static StringBuilder sb = new StringBuilder();

	static class Node {
		int data;
		Node next = null;

		public Node(int data) {
			this.data = data;
		}
	}

	static class LinkedList {
		Node head = null;
		Node tail = null;
		int nodeCount = 0;

		public void insert(int x, int[] insertCode) {

			int startI = 0;
			// x가 0인 경우
			if (x == 0) {
				if (nodeCount == 0) {
					Node node = new Node(insertCode[0]);
					nodeCount = 1;
					startI = 1;
					head = node;
					tail = node;
				} else {
					Node node = new Node(insertCode[0]);
					nodeCount++;
					startI = 1;
					node.next = head;
					head = node;
				}
			}

			// idx만큼 이동
			Node cur = head;
			for (int i = 1; i < x; i++) {
				if (cur.next == null)
					break;
				else
					cur = cur.next;
			}
			// insertCode 개수 만큼 삽입
			for (int i = startI; i < insertCode.length; i++) {
				Node node = new Node(insertCode[i]);
				node.next = cur.next;
				cur.next = node;
				nodeCount++;
				cur = cur.next;
			}
		}

		public void delete(int x, int y) {

			if (nodeCount == 0) {
				return;
			}
			
			Node cur = head;

			if (x == 0) {
				for(int i=0;i<y;i++) {
					if(cur.next == null)break;
					cur = cur.next;
				}
				head = cur;
				return;
			}

			
			for (int i = 1; i < x; i++) {
				if (cur.next == null)
					break;
				else
					cur = cur.next;
			}

			for (int i = 0; i < y; i++) {
				if (cur.next == null)
					break;

				cur.next = cur.next.next;
				nodeCount--;
			}

		}

		public void append(int[] appendCodes) {
			// head 가 비어있는 경우
			int startI = 0;
			if (nodeCount == 0) {
				Node node = new Node(appendCodes[0]);
				nodeCount = 1;
				startI = 1;
				head = node;
				tail = node;
			}
			// idx만큼 이동
			Node cur = head;
			for (int i = startI+1; i < nodeCount; i++) {
				if (cur.next == null)
					break;
				else
					cur = cur.next;
			}
			// insertCode 개수 만큼 삽입
			for (int i = startI; i < appendCodes.length; i++) {
				Node node = new Node(appendCodes[i]);
				node.next = cur.next;
				cur.next = node;
				cur = cur.next;
				nodeCount++;
			}
		}

		public void print() {

			if (nodeCount == 0)
				return;

			Node cur = head;
			for (int i = 0; i < 10; i++) {

				sb.append(cur.data + " ");

				if (cur.next == null)
					break;
				cur = cur.next;
			}
		}

	}

	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {

			N = Integer.parseInt(in.readLine());
			String[] codes = in.readLine().split(" ");
			int[] datas = new int[N];
			for (int i = 0; i < N; i++) {
				datas[i] = Integer.parseInt(codes[i]);
			}

			LinkedList LL = new LinkedList();
			LL.append(datas);

			int cmdCount = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());

			for (int k = 0; k < cmdCount; k++) {

				String cmd = st.nextToken();

				if (cmd.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());

					int[] insertCodes = new int[y];

					for (int i = 0; i < y; i++) {
						insertCodes[i] = Integer.parseInt(st.nextToken());
					}

					LL.insert(x, insertCodes);

				} else if (cmd.equals("D")) {

					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());

					LL.delete(x, y);

				} else if (cmd.equals("A")) {

					int y = Integer.parseInt(st.nextToken());
					int[] appendCode = new int[y];
					for (int i = 0; i < y; i++) {
						appendCode[i] = Integer.parseInt(st.nextToken());
					}

					LL.append(appendCode);

				}
			}

			sb.append("#" + tc + " ");
			LL.print();
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
