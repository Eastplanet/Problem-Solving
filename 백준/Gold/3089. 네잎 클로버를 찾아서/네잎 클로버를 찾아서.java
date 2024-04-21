import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

	static int N, M;

	static int[][] clovas;
	static List<int[]> orderY;
	static List<int[]> orderX;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		clovas = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			clovas[i][0] = y;
			clovas[i][1] = x;
		}

		// orderX는 X로정렬 이후 같다면 Y로 정렬
		orderX = Arrays.stream(clovas).sorted((a1, a2) -> {
			if (a1[1] == a2[1]) {
				return a1[0] - a2[0];
			} else {
				return a1[1] - a2[1];
			}
		}).collect(Collectors.toList());

		// orderY는 Y로 정렬 이후 같다면 X로 정렬
		orderY = Arrays.stream(clovas).sorted((a1, a2) -> {
			if (a1[0] == a2[0]) {
				return a1[1] - a2[1];
			} else {
				return a1[0] - a2[0];
			}
		}).collect(Collectors.toList());

		String cmd = in.readLine();

		int nowX = 0, nowY = 0;

		for (int i = 0; i < M; i++) {
			char c = cmd.charAt(i);

			int ret;

			if (c == 'R') {
				ret = binarySearch(orderY, nowY, 0,nowX);
				int[] next = orderY.get(ret+1);
				nowX = next[1];
				nowY = next[0];
			} else if (c == 'L') {
				ret = binarySearch(orderY, nowY, 0,nowX);
				int[] next = orderY.get(ret-1);
				nowX = next[1];
				nowY = next[0];
			} else if (c == 'U') {
				ret = binarySearch(orderX, nowX, 1,nowY);
				int[] next = orderX.get(ret+1);
				nowX = next[1];
				nowY = next[0];
			} else if (c == 'D') {
				ret = binarySearch(orderX, nowX, 1,nowY);
				int[] next = orderX.get(ret-1);
				nowX = next[1];
				nowY = next[0];
			}
		}
		
		System.out.println(nowX + " "+nowY);

	}

	// 1. R -> 좌우로 살펴야함 , orderY리스트에서 현재 y인 범위를 가져온다
	// 2. 현재 좌표보다 큰 X를 찾고 현재 위치를 거기로 갱신한다.
	// #1. R orderY에서 현재 좌표를 찾는다. index+1한다.

	// 1. R,L 인경우 orderY에서 현재 Y인 범위를 가져온다. (이진탐색 2번)
	// 2. 현재 좌표보다 큰/작은 X를 찾고 현재 위치를 거기로 갱신한다. (이진 탐색)

	// list를 입력 받고, list.get(?)[XorY] 가 target인 부분을 리턴한다.

	static int binarySearch(List<int[]> list, int target, int XorY, int target2) {
		int[] ret = new int[2];

		int start = 0;
		int end = list.size() - 1;

		ret[0] = Integer.MAX_VALUE;
		ret[1] = Integer.MIN_VALUE;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (list.get(mid)[XorY] > target) {
				end = mid - 1;
			} else if (list.get(mid)[XorY] < target) {
				start = mid + 1;
			} else {
				ret[0] = Math.min(ret[0], mid);
				end = mid - 1;
			}
		}

		start = 0;
		end = list.size() - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (list.get(mid)[XorY] > target) {
				end = mid - 1;
			} else if (list.get(mid)[XorY] < target) {
				start = mid + 1;
			} else {
				ret[1] = Math.max(ret[1], mid);
				start = mid + 1;
			}
		}

		
		start = ret[0];
		end = ret[1];
		
		if(XorY == 0)XorY = 1;
		else XorY = 0;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			if(list.get(mid)[XorY] > target2) {
				end = mid - 1;
			}
			else if(list.get(mid)[XorY] < target2) {
				start = mid + 1;
			}
			else {
				return mid;
			}
		}
		
		//error 못 찾을 수 없음
		return -1;
	}

	

}