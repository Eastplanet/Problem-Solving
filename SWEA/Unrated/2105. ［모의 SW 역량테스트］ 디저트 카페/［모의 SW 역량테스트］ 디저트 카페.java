import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N, maxEat;
	static int[][] arr;
	static int[] leng = new int[2];
	static int[] dx = {1,-1,-1,1};
	static int[] dy = {1,1,-1,-1};
	

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			init();
			makePerm(0);
			sb.append("#").append(tc).append(" ").append(maxEat).append("\n");
		}
		System.out.println(sb);
	}

	// 직사각형들을 만들어 본다.
	static void makePerm(int idx) {
		if (idx == 2) {
			//만들어진 직사각형으로 투어 시작
			tour();
			return;
		}
		for (int i = 1; i <= N; i++) {
			leng[idx] = i;
			makePerm(idx + 1);
		}
	}

	// 주어진 직사각형대로 가본다
	static void tour() {
		//모든 정점에서 주어진 직사각형대로 가보려고 시도
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//직사각형이 범위 초과하는지 검사
				if (!canTour(j, i))continue;

				int[] visit = new int[101];
				int count = 0;
				int startx = j, starty = i;
				boolean flag = true;
				
				//직사각형대로 투어 해봄
				for (int k = 0; k < 4; k++) {
					for(int d = 0;d<leng[k%2];d++) {
						if(visit[arr[starty][startx]] == 1) {
							flag = false;
							break;
						}
						visit[arr[starty][startx]] = 1;
						count++;
						startx += dx[k];
						starty += dy[k];
					}
				}
				
				if(flag == false) continue;
				
				if(maxEat < count) {
					maxEat = count;
				}

			}
		}
	}

	// 직사각형이 범위를 초과하는지 확인한다
	static boolean canTour(int startX, int startY) {

		int x = startX + leng[0];
		int y = startY + leng[0];
		if (!isIn(x, y))return false;

		x -= leng[1];
		y += leng[1];
		if (!isIn(x, y))return false;

		x -= leng[0];
		y -= leng[1];
		if (!isIn(x, y))return false;

		return true;
	}

	static boolean isIn(int x, int y) {
		if (x < 0 || x >= N)return false;
		if (y < 0 || y >= N)return false;
		return true;
	}

	static void init() throws Exception {
		N = Integer.parseInt(in.readLine());
		maxEat = -1;
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}