import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	// 층 수, 가로, 세로, 사람 수
	public static int F, W, L, N;
	public static Node[] nodes;
	public static int[] u;
	public static int[][] arr;
	public static int[][] dp;

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(in.readLine());
		
		while (T-- > 0) {
			
			input();

			for(int i=0;i<=N;i++) {
				for(int j=0;j<=N;j++) {
					if(i == j) {
						continue;
					}
					arr[i][j] = Node.getBetweenTime(nodes[i], nodes[j]);
				}
			}
			
			// 0번에서 출발해서 모든 곳을 방문
			int time = topDown(0, (1 << (N+1)) - 1);
			System.out.println(time);
		}
	}
	
	// start에서 시작해서 set 집합을 전부 방문하기 위한 시간
	
	// dp[1][{1,2,3}] -> 1에서 출발해서 1,2,3을 방문하는 경우는
	// arr[1][2] + dp[2][{2,3}] -> 1에서 2로 가는 시간 + 2에서 출발해서 2,3을 방문하는 시간
	// arr[1][3] + dp[3][{2,3}] -> 1에서 3로 가는 시간 + 3에서 출발해서 2,3을 방문하는 시간 중 하나이다.
	public static int topDown(int start, int set) {
		
		// base case
		// [start][{start}] start만 set으로 가지고 있는 경우 -> 거리 0
		if(set == (1 << start)) {
			return 0;
		}
		
		// 메모이제이션
		if(dp[start][set] != 0) {
			return dp[start][set];
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int i=0;i<=N;i++) {
			if(i == start) {
				continue;
			}
			// set에 i가 포함되어 있다면
			if(isIncludeIdxToSet(i, set)) {
				min = Math.min(min , arr[start][i] + topDown(i, set^(1<<start)));
			}
		}
		
		return dp[start][set] = min;
	}
	
	
	// idx번이 set에 포함되어 있나요?
	public static boolean isIncludeIdxToSet(int idx, int set) {
		int bit = (set >> idx) & 1;
		return bit == 1;
	}


	public static void input() throws Exception {
		st = new StringTokenizer(in.readLine());
		F = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		
		nodes = new Node[N + 1];
		for (int i = 0; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			int z = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			nodes[i] = new Node(z, x, y);
		}
		
		// N = 2인 경우, 000까지 표현할 수 있어야함 (편의점 )
		// 1 << 1 = 10
		// 1 << 2 = 100
		dp = new int[N+1][(1 << (N+1))];
		arr = new int[N+1][N+1];
		
	}
	
	public static class Node {
		int f, x, y;
		public Node(int f, int x, int y) {
			this.f = f;
			this.x = x;
			this.y = y;
		}

		// 두 노드 사이 이동 거리
		public static int getBetweenTime(Node a, Node b) {

			// 에스컬레이터의 x좌표
			int[] ex = { 1, 1  , W, W };
			int[] ey = { 1, L,   1, L };

			// 층이 같은 경우 그냥 이동
			if (a.f == b.f) {
				return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
			}

			int min = Integer.MAX_VALUE;
			// 층이 다른 경우 에스컬레이터 이용
			// i 번 에스컬레이터 이용 비용
			for(int i=0;i<4;i++) {
				// a번 노드에서 i번 에스컬레이터 이용 비용
				int move1 = Math.abs(a.x - ex[i]) + Math.abs(a.y - ey[i]);
				// i번 에스컬레이터에서 b번 노드로 이용 비용
				int move2 = Math.abs(ex[i] - b.x) + Math.abs(ey[i] - b.y);
				// 에스컬레이터로 이동하는 비용
				
				int move3 = 0;
				// a -> b로 올라가는 경우
				if(a.f < b.f) {
					move3 = 2 * Math.abs(a.f - b.f);
				}
				else {
					move3 = Math.abs(a.f - b.f);
				}
				
				// 갱신
				min = Math.min(min, move1 + move2 + move3);
			}
			
			return min;
		}
	}

}