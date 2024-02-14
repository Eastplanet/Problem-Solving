import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int moveTime, bcCount;
	static int[] userA,userB;
	static BC[] bcList;
	static int[][] movepos = { { 0, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };


	static class BC {
		int x, y , range, power;

		BC(int x, int y, int range, int power) {
			this.x = x;
			this.y = y;
			this.range = range;
			this.power = power;
		}

	}

	public static boolean isIn(BC bc, int x, int y) {
		if (bc.range >= Math.abs(bc.x - x) + Math.abs(bc.y - y)) {
			return true;
		}
		return false;
	}
	

	public static void main(String[] args) throws Exception {
		


		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			init();

			// x, y
			int[] APos = { 1, 1 };
			int[] BPos = { 10, 10 };
			
			int sum = 0;

			for (int i = 0; i <= moveTime; i++) {
				
				int Adt = userA[i];
				int Bdt = userB[i];

				APos[0] += movepos[Adt][0];
				APos[1] += movepos[Adt][1];
				BPos[0] += movepos[Bdt][0];
				BPos[1] += movepos[Bdt][1];
				
				ArrayList<Integer> A = new ArrayList<>();
				ArrayList<Integer> B = new ArrayList<>();

				for (int j = 0; j < bcCount; j++) {
					if (isIn(bcList[j], APos[0], APos[1])) {
						A.add(j);
					}
					if (isIn(bcList[j], BPos[0], BPos[1])) {
						B.add(j);
					}
				}
				
				
				int max = 0;

				Collections.sort(A, (e1, e2) -> {
					return bcList[e2].power - bcList[e1].power;
				});
				Collections.sort(B, (e1, e2) -> {
					return bcList[e2].power - bcList[e1].power;
				});

				if (A.isEmpty() && B.isEmpty()) {
					continue;
				} 
				else if (!A.isEmpty() && !B.isEmpty()) {
					if (A.get(0) != B.get(0)) {
						sum += bcList[A.get(0)].power;
						sum += bcList[B.get(0)].power;
						continue;
					}

					int caseA = bcList[A.get(0)].power;

					int caseB = 0;
					if (B.size() >= 2) {
						caseB = bcList[A.get(0)].power + bcList[B.get(1)].power;
					}
					int caseC = 0;
					if (A.size() >= 2) {
						caseC = bcList[A.get(1)].power + bcList[B.get(0)].power;
					}

					max = Math.max(caseA, caseB);
					max = Math.max(max, caseC);

					sum += max;

					continue;
				} else if (!B.isEmpty()) {
					sum += bcList[B.get(0)].power;
				} else {
					sum += bcList[A.get(0)].power;
				}
				
			}

			sb.append("#").append(tc).append(" ").append(sum).append("\n");

		}
		System.out.println(sb);
	}

	public static void init() throws Exception {
		StringTokenizer st = new StringTokenizer(in.readLine());
		moveTime = Integer.parseInt(st.nextToken());
		bcCount = Integer.parseInt(st.nextToken());

		userA = new int[moveTime + 1];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i <= moveTime; i++) {
			if (i == 0)
				userA[i] = 0;
			else
				userA[i] = Integer.parseInt(st.nextToken());
		}

		userB = new int[moveTime + 1];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i <= moveTime; i++) {
			if (i == 0)
				userB[i] = 0;
			else
				userB[i] = Integer.parseInt(st.nextToken());
		}

		bcList = new BC[bcCount];
		for (int i = 0; i < bcCount; i++) {
			st = new StringTokenizer(in.readLine());
			bcList[i] = new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}


	}
}