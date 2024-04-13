import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Pos {
		int y, x;
		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
		static boolean isEqual(Pos a,Pos b) {
			return a.x == b.x && a.y == b.y;
		}
	}
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
//	static Queue<Pos> nextq;
	
	// 두 거위의 위치
	static Pos[] L;
	// disjoint set
	static Pos[][] u;
	

	public static void main(String[] args) throws Exception {
		init();
		// 물을 집합으로 표현한다.
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '.') {
					unionForNearWater(j,i);
				}
			}
		}
		
		
		
		
		// 최초 1번은 R * C 만큼 순회하며 BFS를 돌린다.
		// 이후에는 nextq를 이용해서 이 큐에 들어있는 값으로만 BFS 돌린다
		// 한번 visited한 곳은 갈 필요가 없기 때문
		
		
		Queue<Pos> q = new ArrayDeque<>();
		visited = new boolean[R][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j] == '.') {
					q.add(new Pos(i,j));
					visited[i][j] = true;
				}
			}
		}
		
		int time = 0;
		// 바로 만나는 경우???
		if(Pos.isEqual(find(L[0]), find(L[1]))) {
			System.out.println(time);
			return;
		}
		
		time++;
		
		while(true) {
			
			// 얼음을 녹인다.
			q = BFS(q);
			//두 거위의 물이 같은 집합에 속했는지 확인한다.
			if(Pos.isEqual(find(L[0]), find(L[1]))) {
				break;
			}
			time++;
		}
		
		System.out.println(time);
	}
	
	static Queue<Pos> BFS(Queue<Pos> q) {
		Queue<Pos>nextq = new ArrayDeque<>();
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			
			for(int i=0;i<4;i++) {
				int gox = cur.x + dx[i];
				int goy = cur.y + dy[i];
				if(!isIn(gox, goy) || visited[goy][gox])continue;
				
				// 얼음을 녹이고 주변과 union 한다.
				if(map[goy][gox] == 'X') {
					map[goy][gox] = '.';
					visited[goy][gox] = true;
					nextq.add(new Pos(goy,gox));
					unionForNearWater(gox, goy);
				}
				else if(map[goy][gox] == '.') {
					visited[goy][gox] = true;
					q.add(new Pos(goy, gox));
				}
			}
		}
		
		return nextq;
	}

	static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		u = new Pos[R][C];
		
//		nextq = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				u[i][j] = new Pos(-1, -1);
			}
		}
		L = new Pos[2];
		int cnt = 0;
		for (int i = 0; i < R; i++) {
			String tmp = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);

				// 백조의 위치를 저장, 물로 바꾼다.
				if (map[i][j] == 'L') {
					L[cnt++] = new Pos(i, j);
					map[i][j] = '.';
				}
			}
		}
	}
	
	// 주변의 물과 merge 수행
	static void unionForNearWater(int x,int y) {
		for(int i=0;i<4;i++) {
			int gox = x + dx[i];
			int goy = y + dy[i];
			if(!isIn(gox,goy) || map[goy][gox] != '.')continue;
			merge(new Pos(y,x), new Pos(goy,gox));
		}
	}

	static Pos find(Pos a) {
		if (u[a.y][a.x].x == -1 && u[a.y][a.x].y == -1) {
			return a;
		}
		return u[a.y][a.x] = find(u[a.y][a.x]);
	}

	static void merge(Pos a, Pos b) {
		a = find(a);
		b = find(b);
		if (a.x == b.x && a.y == b.y)return;
		
		u[b.y][b.x].x = a.x;
		u[b.y][b.x].y = a.y;
	}

	static boolean isIn(int x, int y) {
		if (x < 0 || x >= C)return false;
		if (y < 0 || y >= R)return false;
		return true;
	}

}