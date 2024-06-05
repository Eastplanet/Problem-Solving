import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int L = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(in.readLine());
		int dir = 1;
		int[][] ants = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			ants[i][0] = Integer.parseInt(st.nextToken());
			if (st.nextToken().charAt(0) == 'D') {
				ants[i][1] = 1;
			} else {
				ants[i][1] = -1;
			}
		}

		/*
		 * 1. 개미들의 순서가 유지된다. 2. 개미끼리의 부딪힘을 무시하고 벽과의 부딪힘만 생각해도 된다.
		 */

		// 그대로
		T %= L * 2;

		ArrayList<Integer> antPos = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int nowPos = ants[i][0];
			int nowDir = ants[i][1] * dir;

			int tmpT = T;
			int tmpDir = nowDir;

			while (true) {

				if (tmpDir == 1) {
					if (nowPos + tmpT <= L) {
						antPos.add(nowPos + tmpT);
						break;
					} else {
						tmpT -= L-nowPos;
						nowPos = L;
						tmpDir *= -1;
						continue;
					}
				} else {
					if (nowPos - tmpT >= 0) {
						antPos.add(nowPos - tmpT);
						break;
					} else {
						tmpT -= nowPos;
						nowPos = 0;
						tmpDir *= -1;
						continue;
					}
				}

			}
		}

		Collections.sort(antPos);

		for (int i = 0; i < N; i++) {
			System.out.print(antPos.get(i) + " ");
		}

	}
}