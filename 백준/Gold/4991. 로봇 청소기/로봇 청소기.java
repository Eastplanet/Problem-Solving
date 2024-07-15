import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	/*
	 * 더러운 칸이 10개 미만 -> 비트 마스킹? (메모리 떄문에 비트마스킹 해야할 듯?) 다익스트라? -> 방문 [y][x][bit]
	 * 
	 * 현재 위치에서 갈 수 있는 곳 전부 Queue에 넣기 가장 짧은 위치 뽑기(이때까지 이동 거리가)
	 * 
	 * 
	 * point to point 거리?? -> BFS 돌아야 하나?? point에서 바로 point로 이동 시키지 말고, 빈칸들도 방문?
	 * 
	 */

	static int W, H;
	static char[][] arr;
	static int[][][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {

		while (true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			if (W == 0 && H == 0)
				break;
			arr = new char[H][W];

			PriorityQueue<Item> pq = new PriorityQueue<>();
			List<int[]> trashes = new ArrayList<>();

			int cnt = 0;
			for (int i = 0; i < H; i++) {
				String tmp = in.readLine();
				for (int j = 0; j < W; j++) {
					arr[i][j] = tmp.charAt(j);
					if (arr[i][j] == 'o') {
						pq.add(new Item(i, j, 0, 0));
					} else if (arr[i][j] == '*') {
						arr[i][j] = (char)('0'+cnt);
						cnt++;
						trashes.add(new int[] { i, j });
					}
				}
			}

			// 쓰레기가 1개면 [2] -> [0]하고 [1]만 존재.
			// 쓰레기가 2개면 [4] -> [00][01][10][11] 존재.
			// 모든 쓰레기 방문 시 (1<<trashes.size())-1
			visited = new int[H][W][1 << trashes.size()];

			boolean isFind = false;
			// 다익스트라 돌린다.
			while (!pq.isEmpty()) {

				Item curr = pq.poll();
				
				if(visited[curr.y][curr.x][curr.bit]==1)continue;
				
				visited[curr.y][curr.x][curr.bit] = 1;
				
				if (curr.bit == (1 << trashes.size()) - 1) {
					System.out.println(curr.moveCount);
					isFind = true;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int gox = dx[i] + curr.x;
					int goy = dy[i] + curr.y;
					if(isIn(goy, gox) && visited[goy][gox][curr.bit]==0) {
						if(arr[goy][gox] >= '0' && arr[goy][gox] <= '9') {
							pq.add(new Item(goy,gox,(curr.bit | (1 << arr[goy][gox]-'0')),curr.moveCount+1));
						}
						else {
							pq.add(new Item(goy,gox,curr.bit,curr.moveCount+1));
						}
					}
				}

//				for (int i = 0; i < trashes.size(); i++) {
//					if (isVisited(i, curr.bit))
//						continue;
//					int[] next = trashes.get(i);
//					int goy = next[0];
//					int gox = next[1];
//
//					pq.add(new Item(goy, gox, (curr.bit | (1 << i)),
//							retManhattanDist(curr, goy, gox) + curr.moveCount));
//
//				}
			}

			if (isFind == false) {
				System.out.println("-1");
			}
		}
	}

	static boolean isIn(int goy, int gox) {
		if (gox < 0 || gox >= W || goy < 0 || goy >= H) return false;
		if(arr[goy][gox] == 'x')return false;
		return true;
	}

//    static int retManhattanDist(Item curr, int goy, int gox) {
//    	return Math.abs(curr.y-goy)+Math.abs(curr.x-gox);
//    }

//	static boolean isVisited(int idx, int bit) {
//		if (((bit >> (idx)) & 1) == 1)
//			return true;
//		return false;
//	}

	static class Item implements Comparable<Item> {
		int y, x, bit, moveCount;

		public Item(int y, int x, int bit, int moveCount) {
			this.y = y;
			this.x = x;
			this.bit = bit;
			this.moveCount = moveCount;
		}

		public int compareTo(Item o) {
			return this.moveCount - o.moveCount;
		}
	}

}