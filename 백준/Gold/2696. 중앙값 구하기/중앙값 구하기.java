import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	// 최대 힙
	static PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
	// 최소 힙
	static PriorityQueue<Integer> right = new PriorityQueue<>((o1, o2) -> o1 - o2);

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			left.clear();
			right.clear();

			int N = Integer.parseInt(in.readLine());
			int cnt = 0;
			
			if(N%2==1) {
				sb.append(N/2+1).append("\n");
			}
			else {
				sb.append(N/2).append("\n");
			}
			
			int printCnt = 0;
			
			while (cnt != N) {
				if (cnt % 10 == 0) {
					st = new StringTokenizer(in.readLine());
				}
				

				int val = Integer.parseInt(st.nextToken());
				cnt++;
				insert(val);
				trim();
				if (cnt % 2 == 1) {
					sb.append(pop() + " ");
					printCnt++;
					if(printCnt % 10 == 0) {
						sb.append("\n");
					}
				}
			}
			if(printCnt%10 != 0) {
				sb.append("\n");
			}
		}
		
		System.out.println(sb);

	}

	static void insert(int val) {
		if (left.isEmpty() && right.isEmpty()) {
			right.add(val);
		} else if (left.isEmpty()) {
			right.add(val);
			left.add(right.poll());
		} else if (right.isEmpty()) {
			left.add(val);
			right.add(left.poll());
		} else {
			right.add(val);
			left.add(right.poll());
		}
	}
	
	static void trim() {
		int diff = Math.abs(left.size()-right.size());
		if(diff >= 2) {
			if(left.size()> right.size()) {
				right.add(left.poll());
			}
			else {
				left.add(right.poll());
			}
		}
		
	}

	static int pop() {
		if (left.size() > right.size()) {
			return left.peek();
		} else {
			return right.peek();
		}
	}
}