import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] arr;
	static int[][] visited;
	static int maxValue = 0;

	// 123
	// 456
	// 789
	// 125, 365, 985, 745, 325, 965, 785, 145

	static int[][] shape = { 
//			{ 1, 2, 5 }, { 3, 6, 5 }, { 9, 8, 5 }, { 7, 4, 5 }, { 3, 2, 5 }, { 9, 6, 5 }, { 7, 8, 5 }, { 1, 4, 5 } 
			{ 9, 8, 5 }, { 7, 4, 5 },{ 7, 8, 5 }, { 9, 6, 5 }
	};

	static int[][][] movepos = new int[4][3][2];

	static void transShapeToMovepos() {

		for (int i = 0; i < shape.length; i++) {
			for (int j = 0; j < 3; j++) {

				switch (shape[i][j]) {
				case 1:
					movepos[i][j][0] = -1;
					movepos[i][j][1] = -1;
					break;
				case 2:
					movepos[i][j][0] = -1;
					movepos[i][j][1] = 0;
					break;
				case 3:
					movepos[i][j][0] = -1;
					movepos[i][j][1] = 1;
					break;
				case 4:
					movepos[i][j][0] = 0;
					movepos[i][j][1] = -1;
					break;
				case 5:
					movepos[i][j][0] = 0;
					movepos[i][j][1] = 0;
					break;
				case 6:
					movepos[i][j][0] = 0;
					movepos[i][j][1] = 1;
					break;
				case 7:
					movepos[i][j][0] = 1;
					movepos[i][j][1] = -1;
					break;
				case 8:
					movepos[i][j][0] = 1;
					movepos[i][j][1] = 0;
					break;
				case 9:
					movepos[i][j][0] = 1;
					movepos[i][j][1] = 1;
					break;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		transShapeToMovepos();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		backTrack(0, 0, 0);

		System.out.println(maxValue);

	}

	static void backTrack(int y, int weaponCnt, int powerCount) {

		maxValue = Math.max(maxValue, powerCount);

		for (int i = y; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (visited[i][j] == 0) {

					for (int k = 0; k < 4; k++) {

						boolean ok = true;
						for (int o = 0; o < 3; o++) {
							int goy = i + movepos[k][o][0];
							int gox = j + movepos[k][o][1];
							if (isIn(goy, gox) && visited[goy][gox] == 0) {
								continue;
							}
							ok = false;
						}

						if (!ok) {
							continue;
						}

						int sum = 0;

						for (int o = 0; o < 3; o++) {
							int goy = i + movepos[k][o][0];
							int gox = j + movepos[k][o][1];
							visited[goy][gox] = 1;
							if (o == 1) {
								sum += arr[goy][gox] * 2;
							} else {
								sum += arr[goy][gox];
							}

						}

						backTrack(i, weaponCnt + 1, powerCount + sum);

						for (int o = 0; o < 3; o++) {
							int goy = i + movepos[k][o][0];
							int gox = j + movepos[k][o][1];
							visited[goy][gox] = 0;
						}
					}

				}

			}
		}

	}

	static boolean isIn(int y, int x) {
		if (x < 0 || x >= M)
			return false;
		if (y < 0 || y >= N)
			return false;
		return true;
	}
}