import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Main {

	static int N;
	static int arr[][], visited[][][];
	static Train startTrain, goalTrain;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		init();

		Queue<Train> q = new ArrayDeque<>();
		q.add(startTrain);
		visited[startTrain.pos.y][startTrain.pos.x][startTrain.dir] = 1;

		while (!q.isEmpty()) {
			Train cur = q.poll();
			
			if(cur.pos.y == goalTrain.pos.y &&
			   cur.pos.x == goalTrain.pos.x &&
			   cur.dir   == goalTrain.dir) {
				System.out.println(cur.mvCount);
				return;
			}

			if (canRotate(cur)) {
				Train tmp = getTrain(cur);
				tmp.tranDir();
				if (visited[tmp.pos.y][tmp.pos.x][tmp.dir] == 0) {
					visited[tmp.pos.y][tmp.pos.x][tmp.dir] = 1;
					tmp.mvCount = cur.mvCount + 1;
					q.add(tmp);
				}
			}
			if (canU(cur)) {
				Train tmp = getTrain(cur);
				tmp.pos.y = tmp.pos.y - 1;

				if (visited[tmp.pos.y][tmp.pos.x][tmp.dir] == 0) {
					visited[tmp.pos.y][tmp.pos.x][tmp.dir] = 1;
					tmp.mvCount = cur.mvCount + 1;
					q.add(tmp);
				}
			}
			if (canD(cur)) {
				Train tmp = getTrain(cur);
				tmp.pos.y = tmp.pos.y + 1;
				
				if (visited[tmp.pos.y][tmp.pos.x][tmp.dir] == 0) {
					visited[tmp.pos.y][tmp.pos.x][tmp.dir] = 1;
					tmp.mvCount = cur.mvCount + 1;
					q.add(tmp);
				}
			}
			if(canL(cur)) {
				Train tmp = getTrain(cur);
				tmp.pos.x = tmp.pos.x - 1;
				
				if (visited[tmp.pos.y][tmp.pos.x][tmp.dir] == 0) {
					visited[tmp.pos.y][tmp.pos.x][tmp.dir] = 1;
					tmp.mvCount = cur.mvCount + 1;
					q.add(tmp);
				}
			}
			if(canR(cur)) {
				Train tmp = getTrain(cur);
				tmp.pos.x = tmp.pos.x + 1;
				
				if (visited[tmp.pos.y][tmp.pos.x][tmp.dir] == 0) {
					visited[tmp.pos.y][tmp.pos.x][tmp.dir] = 1;
					tmp.mvCount = cur.mvCount + 1;
					q.add(tmp);
				}
			}
		}
		
		System.out.println("0");

	}
	
	static boolean canL(Train t) {
		if (t.dir == 1) {
			// 위로 한칸 그리고 오른쪽 3칸이 넉넉한지
			for (int i = t.pos.y - 1; i <= t.pos.y + 1; i++) {
				if (canGo(i,t.pos.x-1) == false) {
					return false;
				}
			}

		} else {
			// 오른쪽 2칸 앞이 넉넉하진
			if (canGo(t.pos.y,t.pos.x-2) == false) {
				return false;
			}
		}
		return true;
	}
	
	static boolean canR(Train t) {
		if (t.dir == 1) {
			// 위로 한칸 그리고 오른쪽 3칸이 넉넉한지
			for (int i = t.pos.y - 1; i <= t.pos.y + 1; i++) {
				if (canGo(i,t.pos.x+1) == false) {
					return false;
				}
			}

		} else {
			// 오른쪽 2칸 앞이 넉넉하진
			if (canGo(t.pos.y,t.pos.x+2) == false) {
				return false;
			}
		}
		return true;
	}

	static boolean canD(Train t) {
		if (t.dir == 0) {
			// 아래로 한칸 그리고 좌우 3칸이 넉넉한지
			for (int j = t.pos.x - 1; j <= t.pos.x + 1; j++) {
				if (canGo(t.pos.y + 1, j) == false) {
					return false;
				}
			}

		} else {
			// 아래로 2칸 앞이 넉넉하진
			if (canGo(t.pos.y + 2, t.pos.x) == false) {
				return false;
			}
		}
		return true;
	}

	static boolean canU(Train t) {
		if (t.dir == 0) {
			// 위로 한칸 그리고 좌우 3칸이 넉넉한지
			for (int j = t.pos.x - 1; j <= t.pos.x + 1; j++) {
				if (canGo(t.pos.y - 1, j) == false) {
					return false;
				}
			}

		} else {
			// 위로 2칸 앞이 넉넉하진
			if (canGo(t.pos.y - 2, t.pos.x) == false) {
				return false;
			}
		}
		return true;
	}

	static boolean canRotate(Train t) {

		for (int i = t.pos.y - 1; i <= t.pos.y + 1; i++) {
			for (int j = t.pos.x - 1; j <= t.pos.x + 1; j++) {
				if (canGo(i, j) == false) {
					return false;
				}
			}
		}

		return true;
	}

	static Train getTrain(Train t) {
		Train tmp = new Train();
		tmp.pos = new Pos(t.pos.y, t.pos.x);
		tmp.dir = t.dir;
		return tmp;
	}

	// 밖이거나 나무가있으면 false
	static boolean canGo(int y, int x) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;
		if (arr[y][x] == 1)
			return false;
		return true;
	}

	static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		char map[][] = new char[N][N];
		arr = new int[N][N];
		visited = new int[N][N][2];

		List<Pos> start = new ArrayList<>();
		List<Pos> end = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String tmp = in.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j);

				if (map[i][j] == 'B') {
					map[i][j] = '0';
					start.add(new Pos(i, j));
				} else if (map[i][j] == 'E') {
					map[i][j] = '0';
					end.add(new Pos(i, j));
				}

				arr[i][j] = map[i][j] - '0';
			}
		}
		Collections.sort(start);
		Collections.sort(end);

		startTrain = new Train();
		startTrain.pos = start.get(1);
		// x가 같다면 y방향으로 놓아져있다 -> 세로이다 -> 1
		if (start.get(0).x == start.get(1).x) {
			startTrain.dir = 1;
		} else {
			startTrain.dir = 0;
		}

		goalTrain = new Train();
		goalTrain.pos = end.get(1);
		// x가 같다면 y방향으로 놓아져있다 -> 세로이다 -> 1
		if (end.get(0).x == end.get(1).x) {
			goalTrain.dir = 1;
		} else {
			goalTrain.dir = 0;
		}
	}

	static class Train {
		Pos pos;
		int dir;
		int mvCount;

		void tranDir() {
			if (dir == 0) {
				dir = 1;
			} else {
				dir = 0;
			}
		}
	}

	static class Pos implements Comparable<Pos> {
		int y, x;

		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public int compareTo(Pos o) {
			if (this.y == o.y) {
				return this.x - o.x;
			} else {
				return this.y - o.y;
			}
		}
	}
}