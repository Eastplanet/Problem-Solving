import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, M, C;
	static int[][] arr = new int[N][N];
	static int tmpMaxHoney;
	static int MaxProfit;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			MaxProfit = 0;
			tmpMaxHoney = 0;

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int ai = 0; ai < N; ai++) {
				for (int aj = 0; aj < N; aj++) {
					for (int bi = 0; bi < N; bi++) {
						for (int bj = 0; bj < N; bj++) {
							
							if(aj+M == N + 1 || bj+M == N + 1) {
								continue;
							}
							
							// 높이가 다르면 j끼리 비교 필요 없음
							if (ai != bi) {
								calcHoney(ai, aj, bi, bj);
							}
							// 높이가 같으면 겹치지 않는지 검사해야함
							else {
								if (Math.abs(aj - bj) < M) {
									continue;
								}
								calcHoney(ai, aj, bi, bj);
							}
						}
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(MaxProfit).append("\n");

		}
		
		System.out.println(sb);
	}

	// 벌꿀 계산
	public static void calcHoney(int ai, int aj, int bi, int bj) {
		// A수익
		int startaj = aj;
		int endaj = aj + M - 1;
		if (endaj >= N) {
			endaj = N - 1;
		}
		int[] APowerSet = new int[endaj - startaj + 1];
		back(APowerSet, 0, endaj - startaj + 1, startaj, ai);
		int AProfit = tmpMaxHoney;
		tmpMaxHoney = 0;

		// B 수익
		int startbj = bj;
		int endbj = bj + M - 1;
		if (endbj >= N) {
			endbj = N - 1;
		}
		int[] BPowerSet = new int[endbj - startbj + 1];
		back(BPowerSet, 0, endbj - startbj + 1, startbj, bi);
		int BProfit = tmpMaxHoney;
		tmpMaxHoney = 0;

		if (MaxProfit < AProfit + BProfit) {
			MaxProfit = AProfit + BProfit;
		}

	}

	// 구역을 정해주면 거기서 C 조건에 맞춰 가장 많이 얻을 수 있는 수익을 알려 줌
	public static void back(int[] visited, int idx, int maxIdx, int startaj, int ai) {
		if (idx == maxIdx) {
			int sum = 0;
			int powSum = 0;
			for (int i = 0; i < maxIdx; i++) {
				if (visited[i] == 1) {
					sum += arr[ai][startaj + i];
					powSum += Math.pow(arr[ai][startaj + i], 2);
				}
			}
			if (sum > C)
				return;
			if (tmpMaxHoney < powSum)
				tmpMaxHoney = powSum;
			return;

		}
		visited[idx] = 1;
		back(visited, idx + 1, maxIdx, startaj, ai);
		visited[idx] = 0;
		back(visited, idx + 1, maxIdx, startaj, ai);
	}

}