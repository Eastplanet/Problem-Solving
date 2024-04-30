import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	static Set<String> set = new HashSet<>();
	static char[] prev = new char[7];
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][]arr;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {

			arr = new int[4][4];
			prev = new char[7];
			set = new HashSet<>();
			
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < 4; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					prev[0] = Integer.toString(arr[i][j]).charAt(0);
					DFS(i, j, 0);
				}
			}

			System.out.println("#"+tc+" "+set.size());
		}

	}

	static void DFS(int y, int x, int moveCount) {
		if (moveCount == 6) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<7;i++)sb.append(prev[i]);
			String s = sb.toString();
			set.add(s);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int gox = x + dx[i];
			int goy = y + dy[i];
			if (isIn(goy, gox)) {
				prev[moveCount+1] = Integer.toString(arr[goy][gox]).charAt(0);
				DFS(goy,gox,moveCount+1);
			}
		}

	}

	static boolean isIn(int y, int x) {
		if (x < 0 || x >= 4 || y < 0 || y >= 4)return false;
		return true;
	}
}