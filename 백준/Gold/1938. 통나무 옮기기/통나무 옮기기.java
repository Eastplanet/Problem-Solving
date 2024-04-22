import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static int N;
	static int[][] deltas = { { -1, 0 }, { 0, -1 } };
	static int[][] deltas8 = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };
	static int[] fmOne = { -1, 1 };
	static String[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		// 무조건 중간 값이 위치를 결정함
		map = new String[N][N];
		int bn = 0;
		int en = 0;
		// R, C, 방향을 저장
		int[] start = new int[3];
		int[] end = new int[3];
		// 입력 전처리
		for (int r = 0; r < N; r++) {
			map[r] = in.readLine().split("");
			for (int c = 0; c < N; c++) {
				if (map[r][c].equals("B")) {
					bn++;
					if (bn == 2) {
						start[0] = r;
						start[1] = c;
						for (int d = 0; d < 2; d++) {
							int nr = r + deltas[d][0];
							int nc = c + deltas[d][1];
							if (isIn(nr, nc) && map[nr][nc].equals("B")) {
								start[2] = d;
							}
						}
					}
				}
				if (map[r][c].equals("E")) {
					en++;
					if (en == 2) {
						end[0] = r;
						end[1] = c;
						for (int d = 0; d < 2; d++) {
							int nr = r + deltas[d][0];
							int nc = c + deltas[d][1];
							if (isIn(nr, nc) && map[nr][nc].equals("E")) {
								end[2] = d;
							}
						}
					}
				}
			}
		}

		boolean[][][] isVisited = new boolean[N][N][2];
		Deque<int[]> q = new ArrayDeque<>();
		// R, C, type, moveCnt
		q.offer(new int[] { start[0], start[1], start[2], 0 });
		isVisited[start[0]][start[1]][start[2]] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 1; i <= 5; i++) {
				int[] result = move(now[0], now[1], now[2], i);
				if (result[3] == 1) { // 움직일 수 있는 경우
					if (isVisited[result[0]][result[1]][result[2]]) continue; // 방문체크
					if (result[0] == end[0] && result[1] == end[1] && result[2] == end[2]) { // 종료 조건
						System.out.println(now[3] + 1);
						System.exit(0);
					}
					isVisited[result[0]][result[1]][result[2]] = true;
					q.offer(new int[] { result[0], result[1], result[2], now[3] + 1 });
				}
			}
		}
		System.out.println(0);
	}

	static int[] move(int r, int c, int dir, int type) {
		// result : r, c, dir, isUse
		int[] result = new int[4];
		switch (type) {
		case 1:
			if (dir == 0) { // 세로로 놓인 경우
				int nr = r - 2;
				if (isIn(nr, c) && !map[nr][c].equals("1")) {
					result[0] = r - 1;
					result[1] = c;
					result[2] = dir;
					result[3] = 1; // 사용 가능
				}
			} else if (dir == 1) { // 가로로 놓인 경우
				int nr = r - 1;
				if (isIn(nr, c)) {
					boolean flag = true;
					// 3개의 위치 모두 탐색해야함
					// 현 위치
					if (map[nr][c].equals("1"))
						flag = false;
					for (int d = 0; d < 2; d++) {
						// 양 옆
						int nc = c + fmOne[d];
						if (isIn(nr, nc) && map[nr][nc].equals("1"))
							flag = false;
					}
					if (flag) { // 양 옆 모두 1이 아니면
						result[0] = r - 1;
						result[1] = c;
						result[2] = dir;
						result[3] = 1; // 사용 가능
					}
				}
			}
			break;
		case 2:
			if (dir == 0) { // 세로로 놓인 경우
				int nr = r + 2;
				if (isIn(nr, c) && !map[nr][c].equals("1")) {
					result[0] = r + 1;
					result[1] = c;
					result[2] = dir;
					result[3] = 1; // 사용 가능
				}
			} else if (dir == 1) { // 가로로 놓인 경우
				int nr = r + 1;
				if (isIn(nr, c)) {
					boolean flag = true;
					// 3개의 위치 모두 탐색해야함
					// 현 위치
					if (map[nr][c].equals("1"))
						flag = false;
					for (int d = 0; d < 2; d++) {
						// 양 옆
						int nc = c + fmOne[d];
						if (isIn(nr, nc) && map[nr][nc].equals("1"))
							flag = false;
					}
					if (flag) {
						result[0] = r + 1;
						result[1] = c;
						result[2] = dir;
						result[3] = 1; // 사용 가능
					}
				}
			}
			break;
		case 3:
			if (dir == 0) { // 세로로 놓인 경우
				int nc = c - 1;
				if (isIn(r, nc)) {
					boolean flag = true;
					if (map[r][nc].equals("1"))
						flag = false;
					for (int d = 0; d < 2; d++) {
						// 위 아래
						int nr = r + fmOne[d];
						if (isIn(nr, nc) && map[nr][nc].equals("1"))
							flag = false;
					}
					if (flag) { // 양 옆 모두 1이 아니면
						result[0] = r;
						result[1] = c - 1;
						result[2] = dir;
						result[3] = 1; // 사용 가능
					}
				}
			} else if (dir == 1) { // 가로로 놓인 경우
				int nc = c - 2;
				if (isIn(r, nc) && !map[r][nc].equals("1")) {
					result[0] = r;
					result[1] = c - 1;
					result[2] = dir;
					result[3] = 1; // 사용 가능
				}
			}
			break;
		case 4:
			if (dir == 0) { // 세로로 놓인 경우
				int nc = c + 1;
				if (isIn(r, nc)) {
					boolean flag = true;
					if (map[r][nc].equals("1"))
						flag = false;
					for (int d = 0; d < 2; d++) {
						// 위 아래
						int nr = r + fmOne[d];
						if (isIn(nr, nc) && map[nr][nc].equals("1"))
							flag = false;
					}
					if (flag) {
						result[0] = r;
						result[1] = c + 1;
						result[2] = dir;
						result[3] = 1; // 사용 가능
					}
				}
			} else if (dir == 1) { // 가로로 놓인 경우
				int nc = c + 2;
				if (isIn(r, nc) && !map[r][nc].equals("1")) {
					result[0] = r;
					result[1] = c + 1;
					result[2] = dir;
					result[3] = 1; // 사용 가능
				}
			}
			break;
		case 5:
			boolean flag = true;
			for (int d = 0; d < 8; d++) {
				int nr = r + deltas8[d][0];
				int nc = c + deltas8[d][1];
				if (!isIn(nr, nc)) {
					flag = false;
					break;
				}
				if (map[nr][nc].equals("1")) {
					flag = false;
					break;
				}
			}
			if (flag) {
				result[0] = r;
				result[1] = c;
				result[2] = (dir + 1) % 2;
				result[3] = 1;
			}
			break;
		}
		return result;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}