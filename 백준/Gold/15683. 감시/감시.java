import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int[][] camera = { { 0 }, { 0, 2 }, { 0, 1 }, { 0, 1, 2 }, { 0, 1, 2, 3 } };
	static int N, M, blankRoomCount, min;
	static int[][] map;
	static int[] visited;
	static ArrayList<int[]> cameraPos;

	static BufferedReader in;

	public static void main(String[] args) throws Exception {

		in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		min = Integer.MAX_VALUE;
		map = new int[N][M];
		cameraPos = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (1 <= map[i][j] && map[i][j] <= 5) {
					cameraPos.add(new int[] { i, j });
				} else if (map[i][j] == 0) {
					blankRoomCount++;
				}
			}
		}
		visited = new int[cameraPos.size()];

		back(0);

		System.out.println(min);
	}

	public static void back(int idx) {

		if (idx == cameraPos.size()) {
			calcMin();
			return;
		}

		int[] nowPos = cameraPos.get(idx);
		int cameraNum = map[nowPos[0]][nowPos[1]];
		cameraNum--;

		for (int i = 0; i < 4; i++) {
			visited[idx] = i;
			back(idx + 1);
		}

	}
	
	public static void calcMin() {

		int fillCount = 0;
		
		int[][] cpmap = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				cpmap[i][j] = map[i][j];
			}
		}

		for (int i = 0; i < cameraPos.size(); i++) {
			
			int nowCameraNum = cpmap[cameraPos.get(i)[0]][cameraPos.get(i)[1]];
			nowCameraNum--;
			// 현재 카메라가 가능한 각도들
			int[] cameraAng = camera[nowCameraNum];
			int[] tracingCount = new int[cameraAng.length];

			for (int j = 0; j < cameraAng.length; j++) {
				int goy = cameraPos.get(i)[0];
				int gox = cameraPos.get(i)[1];

				while (true) {
					goy += dy[(cameraAng[j] + visited[i]) % 4];
					gox += dx[(cameraAng[j] + visited[i]) % 4];
					if (!isIn(gox, goy)) {
						break;
					}

					if (cpmap[goy][gox] <= 0) {
						if (cpmap[goy][gox] == 0) {
							fillCount++;
						}
						cpmap[goy][gox] -= 1;
						tracingCount[j]++;
					}
				}
			}
		}
		
		if(min > (blankRoomCount - fillCount)) {
			min = blankRoomCount - fillCount;
		}
	}

	public static boolean isIn(int x, int y) {
		if (x < 0 || x >= M)
			return false;
		if (y < 0 || y >= N)
			return false;
		if (map[y][x] == 6)
			return false;

		return true;
	}
}