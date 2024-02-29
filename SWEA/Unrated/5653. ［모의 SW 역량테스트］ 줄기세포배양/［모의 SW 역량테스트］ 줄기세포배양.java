import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, K;
	static HashSet<Cell> hs;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static class Cell implements Comparable<Cell> {
		int y, x, power, wakeTime;
		boolean isDie;

		public Cell(int y, int x, int power, int wakeTime) {
			this.y = y;
			this.x = x;
			this.power = power;
			this.wakeTime = wakeTime;
		}

		@Override
		public int compareTo(Cell o) {
			return o.power - this.power;
		}

		

		@Override
		public int hashCode() {
			final int prime = 523;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cell other = (Cell) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Cell [y=" + y + ", x=" + x + ", power=" + power + ", wakeTime=" + wakeTime + ", isDie=" + isDie
					+ "]";
		}

	}

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			init();

			for (int k = 0; k <= K; k++) {
				ArrayList<Cell> cells = new ArrayList<>(hs);
				Collections.sort(cells);

				for (Cell cell : cells) {
					if (cell.isDie)
						continue;

					if (cell.wakeTime + cell.power == k) {
						cell.isDie = true;
					}

					if (cell.wakeTime == k - 1) {
						for (int i = 0; i < 4; i++) {
							int gox = cell.x + dx[i];
							int goy = cell.y + dy[i];
							Cell tmp = new Cell(goy, gox, cell.power, k + cell.power);

							hs.add(tmp);
						}
					}

				}
			}

			int count = 0;
			ArrayList<Cell> cells = new ArrayList<>(hs);
			for (Cell cell : cells) {
				if (cell.isDie)
					continue;
				count++;
			}

			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}

	public static void init() throws Exception {
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		hs = new HashSet<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp != 0) {
					Cell c = new Cell(i, j, tmp, tmp);
					hs.add(c);
				}
			}
		}
	}
}