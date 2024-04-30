import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Cluster {
		List<int[]> minerals;
	}

	static int R, C;
	static char arr[][];
	static int visited[][];
	static int count;
	static int[] sticks;

	public static void main(String[] args) throws Exception {
		init();

		int dx = 1;
		for (int i = 0; i < count; i++) {
			
			int[] breakPos = findBreak(sticks[i], dx);
			dx *= -1;

			if (breakPos[0] == -1)continue;
			arr[breakPos[0]][breakPos[1]] = '.';
			for (int j = 0; j < R + 1; j++) {
				Arrays.fill(visited[j], 0);
			}

			// 분리된 클러스터
			List<Cluster> clusterList = BFS(visited, breakPos);

			// 클러스터를 내린다.
			fallCluster(clusterList);
			
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

	static void fallCluster(List<Cluster> clusterList) {

		// 각 클러스터에서 아래로 내릴 수 있는 가장 가까운 길이 찾음
		// 내린다.
		for (int i = 0; i < clusterList.size(); i++) {
			int minleng = Integer.MAX_VALUE;

			Cluster cluster = clusterList.get(i);
			for (int j = 0; j < cluster.minerals.size(); j++) {

				int nowY = cluster.minerals.get(j)[0];
				int nowX = cluster.minerals.get(j)[1];

				int leng = 0;
				nowY++;

				while (arr[nowY][nowX] == '.') {
					leng++;
					nowY++;
				}

				minleng = Math.min(minleng, leng);
			}

			for (int j = 0; j < cluster.minerals.size(); j++) {
				
				int nowY = cluster.minerals.get(j)[0] + minleng;
				int nowX = cluster.minerals.get(j)[1];
				
				arr[nowY][nowX] = 'x';
			}

		}

	}

	static List<Cluster> BFS(int[][] visited, int[] breakPos) {

		// 땅바닥부터 bFS돌린다.
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] { R, 0 });
		visited[R][0] = 1;

		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int gox = cur[1] + dx[i];
				int goy = cur[0] + dy[i];
				if (isIn(goy, gox) && arr[goy][gox] == 'x' && visited[goy][gox] == 0) {
					visited[goy][gox] = 1;
					q.add(new int[] { goy, gox });
				}
			}
		}

		// breakPos 위로 visited 안 된 미네랄이 있다면 BFS처리하고 clustList에 담는다.
		List<Cluster> clusterList = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			int gox = breakPos[1] + dx[i];
			int goy = breakPos[0] + dy[i];

			// 내가 임의로 넣은 맨 밑의 미네랄은 진짜 미네랄이 아님
			if (goy == R) {
				continue;
			}
			if (isIn(goy, gox) && arr[goy][gox] == 'x' && visited[goy][gox] == 0) {
				q.add(new int[] { goy, gox });

				visited[goy][gox] = 1;
				Cluster cluster = new Cluster();
				cluster.minerals = new ArrayList<>();
				cluster.minerals.add(new int[] { goy, gox });
				arr[goy][gox] = '.';

				while (!q.isEmpty()) {
					int[] cur = q.poll();

					for (int a = 0; a < 4; a++) {
						int gogox = cur[1] + dx[a];
						int gogoy = cur[0] + dy[a];
						if (isIn(gogoy, gogox) && arr[gogoy][gogox] == 'x' && visited[gogoy][gogox] == 0) {
							visited[gogoy][gogox] = 1;
							arr[gogoy][gogox] = '.';
							q.add(new int[] {gogoy,gogox});
							cluster.minerals.add(new int[] { gogoy, gogox });
						}
					}
				}

				clusterList.add(cluster);
			}
		}

		return clusterList;
	}

	static boolean isIn(int y, int x) {
		if (x < 0 || x >= C)
			return false;
		if (y < 0 || y >= R + 1)
			return false;
		return true;
	}

	static int[] findBreak(int height, int dx) {

		// 입력 받는 배열 순서와 heigh를 맞춰줌
		height = R - height;

		int[] pos = { -1, -1 };
		int startX;
		if (dx == 1) {
			startX = 0;
		} else {
			startX = C - 1;
		}
		while (true) {
			if (startX < 0 || startX >= C)
				break;

			if (arr[height][startX] == 'x') {
				pos[0] = height;
				pos[1] = startX;
				break;
			}
			startX += dx;
		}
		return pos;
	}

	public static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R + 1][C];
		visited = new int[R + 1][C];

		for (int i = 0; i < R; i++) {
			String tmp = in.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = tmp.charAt(j);
			}
		}

		// 가장 바닥을 추가하여 미네랄로 생각
		for (int i = 0; i < C; i++) {
			arr[R][i] = 'x';
		}

		count = Integer.parseInt(in.readLine());
		sticks = new int[count];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < count; i++) {
			sticks[i] = Integer.parseInt(st.nextToken());
		}
	}
}