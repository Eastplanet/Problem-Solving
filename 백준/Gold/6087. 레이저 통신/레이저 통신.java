import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int W, H;
	static char[][] arr;
	static int[][][] visited;

	static int[] start, end;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	
	
	
	/*
	 * 처음 시작할 때 C 4방향으로 BFS 출발 시킨다.(공간 비어있는지 확인 필요)
	 * BFS : 방향 유지 -> 가중치 0, 방향 꺾기 -> 가중치 1
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new char[H][W];
		visited = new int[H][W][4];

		for (int i = 0; i < H; i++) {
			String tmp = in.readLine();
			for (int j = 0; j < W; j++) {
				arr[i][j] = tmp.charAt(j);
				if (arr[i][j] == 'C') {
					if (start == null) {
						start = new int[2];
						start[0] = i;
						start[1] = j;
					} else {
						end = new int[2];
						end[0] = i;
						end[1] = j;
					}
				}
			}
		}
		
		
		PriorityQueue<Laser> pq = new PriorityQueue<>();
		
		for(int i=0;i<4;i++) {
			int gox = start[1] + dx[i];
			int goy = start[0] + dy[i];
			if(canGo(goy, gox, 0)) {
				pq.add(new Laser(goy, gox, 1, i));
			}
		}
		
		
		while(!pq.isEmpty()) {
			
			Laser curr = pq.poll();
			// 방문 체크
			if(visited[curr.y][curr.x][curr.dir] == 1)continue;
			visited[curr.y][curr.x][curr.dir] = 1;
			
			//정답 체크
			if(curr.y == end[0] && curr.x == end[1]) {
				System.out.println(curr.reflexCnt-1);
				break;
			}
			
			for(int i=0;i<4;i++) {
				// 정 반대로는 반사가 될 수 없음
				if(Math.abs(curr.dir - i) == 2)continue;
				
				int gox = curr.x + dx[i];
				int goy = curr.y + dy[i];
				
				Laser laser = new Laser(goy, gox, curr.reflexCnt, i);
				if(i != curr.dir)laser.reflexCnt++;
				
				if(!canGo(goy, gox, laser.dir)) continue;
				pq.add(laser);
				
			}
		}
		
	
	}
	
	static boolean canGo(int goy, int gox, int dir) {
		if(gox < 0 || gox >= W || goy < 0 || goy >= H)return false;
		if(arr[goy][gox] == '*')return false;
		if(visited[goy][gox][dir] == 1)return false;
		return true;
	}
	
	static class Laser implements Comparable<Laser>{
		int y,x;
		int reflexCnt;
		int dir;
		public Laser(int y, int x, int reflexCnt, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.reflexCnt = reflexCnt;
			this.dir = dir;
		}
		@Override
		public int compareTo(Laser o) {
			return this.reflexCnt - o.reflexCnt;
		}
		@Override
		public String toString() {
			return "Laser [y=" + y + ", x=" + x + ", reflexCnt=" + reflexCnt + ", dir=" + dir + "]";
		}
		
	}
}