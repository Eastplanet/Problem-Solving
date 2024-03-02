import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static final int NOT_MOVE = 0, GOAL = 1, MOVE = 2;
	static int N, M;
	static char[][] arr;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static Pos red, blue;
	static int[][][][] visited; // [redy][redx][bluey][bluex]

	static class Pos {
		int y, x;
		boolean isGoal;
		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
		@Override
		public String toString() {
			return "Pos [y=" + y + ", x=" + x + ", isGoal=" + isGoal + "]";
		}
	}

	static class QueueNode {
		Pos red;
		Pos blue;
		int count;

		public QueueNode(Pos red, Pos blue, int count) {
			this.red = new Pos(red.y, red.x);
			this.blue = new Pos(blue.y,blue.x);
			this.count = count;
		}

		@Override
		public String toString() {
			return "QueueNode [red=" + red + ", blue=" + blue + ", count=" + count + "]";
		}
		
		
	}

	public static void main(String[] args) throws Exception {
		init();
		BFS();
	}

	public static void BFS() {

		Queue<QueueNode> q = new ArrayDeque<>();
		q.add(new QueueNode(red, blue, 0));
		

		while (!q.isEmpty()) {
			QueueNode tmp = q.poll();
			Pos curRed = tmp.red;
			Pos curBlue = tmp.blue;
			int curCount = tmp.count;
			
			if(curCount >= 10) {
				System.out.println("-1");
				return;
			}
			
			if(visited[curRed.y][curRed.x][curBlue.y][curBlue.x] == 1) {
				continue;
				}
			visited[curRed.y][curRed.x][curBlue.y][curBlue.x] = 1;

			// 기울일 방향 선택
			for (int i = 0; i < 4; i++) {
				int gox = dx[i];
				int goy = dy[i];

				// 무슨 구슬이 먼저 굴러갈 지 선택
				boolean isRedFirst = getFirst(gox, goy, curRed, curBlue);

				Pos first, second;
				if (isRedFirst) {
					first = new Pos(curRed.y,curRed.x);
					second = new Pos(curBlue.y,curBlue.x);
				} else {
					first = new Pos(curBlue.y,curBlue.x);
					second = new Pos(curRed.y,curRed.x);
				}

				// first와 second 구슬을 굴린다.
				int firstRes = rolling(first, second, gox,goy);
				int secondRes = rolling(second,first,gox,goy);
				
				// 못움직인 경우, 파란공이 들어간 경우 스킵
				if(isContinue(isRedFirst, firstRes, secondRes)) {
					continue;
				}
				
				if(firstRes == GOAL || secondRes == GOAL) {
					System.out.println(curCount+1);
					return;
				}
				
				if(isRedFirst) {
					q.add(new QueueNode(first, second, curCount+1));
				}
				else {
					q.add(new QueueNode(second, first, curCount+1));
				}
			}
		}
		
		System.out.println("-1");
		return;

	}
	
	public static boolean isContinue(boolean isRedFirst, int firstRes, int secondRes) {
		//못움직인 경우
		if(firstRes == NOT_MOVE && secondRes == NOT_MOVE) {
			return true;
		}
		//파란공이 들어간 경우
		if(isRedFirst && secondRes == GOAL) {
			return true;
		}
		//파란공이 들어간 경우
		if( !isRedFirst && firstRes == GOAL) {
			return true;
		}
		
		return false;
	}

	// NOT_MOVE = 0, GOAL = 1, MOVE = 2;
	// 구슬을 움직이고 그 결과를 리턴
	public static int rolling(Pos ball, Pos otherBall, int dx, int dy) {
		int x = ball.x;
		int y = ball.y;
		
		boolean isMoved = false;
		
		while(true) {
			x += dx;
			y += dy;
			
			if(arr[y][x] == '#') {
				break;
			}
			if(otherBall.isGoal == false && y == otherBall.y && x == otherBall.x) {
				break;
			}
			
			
			if(arr[y][x] == 'O') {
				ball.isGoal = true;
				return GOAL;
			}
			else if(arr[y][x] == '.') {
				ball.y = y;
				ball.x = x;
				isMoved = true;
			}
		}
		
		if(isMoved)return MOVE;
		else return NOT_MOVE;
	}
	
	public static boolean getFirst(int gox, int goy,Pos red, Pos blue) {
		boolean isRedFirst;
		if (gox == 0) {
			if (red.x == blue.x) {
				if (N * goy - red.y * goy < N * goy - blue.y * goy) {
					isRedFirst = true;
				} else {
					isRedFirst = false;
				}
			} else {
				isRedFirst = true;
			}
		} else {
			if (red.y == blue.y) {
				if (M * gox - red.x * gox < M * gox - blue.x * gox) {
					isRedFirst = true;
				} else {
					isRedFirst = false;
				}
			} else {
				isRedFirst = true;
			}
		}
		return isRedFirst;
	}
	

	public static void init() throws Exception {
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visited = new int[N][M][N][M];

		for (int i = 0; i < N; i++) {
			String tmp = in.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = tmp.charAt(j);
				if (arr[i][j] == 'R') {
					red = new Pos(i, j);
					arr[i][j] = '.';
				} else if (arr[i][j] == 'B') {
					blue = new Pos(i, j);
					arr[i][j] = '.';
				}
			}
		}
	}
}