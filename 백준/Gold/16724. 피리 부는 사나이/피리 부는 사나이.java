import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

	static final int D = 0, U = 1, R = 2, L = 3;
	static int N,M;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static char[][] map;
	static boolean[][] visited;

	static Pos[][] u;

	
	public static void main(String[] args) throws Exception {
		init();
		// N x M 순회하면서 이어진 칸끼리 merge
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(visited[i][j] == false){
					DFS(i,j);
				}
			}
		}
		
		// 집합의 개수 == 만들어야할 SAFE ZONE
		// 0,0과 다른 집합이면  cnt++  merge
		Pos A = new Pos(0,0);
		int cnt = 1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				Pos B = new Pos(i,j);
				if(find(A).x != find(B).x || find(A).y != find(B).y) {
					cnt++;
					merge(A, new Pos(i,j));
				}
			}
		}
		
		System.out.println(cnt);
		
	}
	
	// 계속 나아가면서 같은 집합으로 만들어준다.
	static void DFS(int y,int x) {
		
		visited[y][x] = true;
		
		int dir;
		if(map[y][x] == 'D')dir = D;
		else if(map[y][x] == 'L')dir = L;
		else if(map[y][x] == 'U')dir = U;
		else dir = R;
		
		int gox = x+dx[dir];
		int goy = y+dy[dir];
		if(isIn(goy,gox)) {
			// 같은 집합으로 만든다
			merge(new Pos(y,x),new Pos(goy,gox));
			// 나아간다.
			if(visited[goy][gox] == false) {
				DFS(goy,gox);
			}
			
		}
	}

	static boolean isIn(int y, int x) {
		if(x < 0 || x>= M)return false;
		if(y < 0 || y>= N)return false;
		return true;
	}
	static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];
		u = new Pos[N][M];
		for (int i = 0; i < N; i++) {
			String tmp = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j);
				u[i][j] = new Pos(-1, -1);
			}
		}
	}
	static class Pos {
		int y, x;
		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
		@Override
		public String toString() {
			return "Pos [y=" + y + ", x=" + x + "]";
		}
		
	}
	static Pos find(Pos a) {
		if (u[a.y][a.x].x == -1) return a;
		return u[a.y][a.x] = find(u[a.y][a.x]);
	}
	static void merge(Pos a, Pos b) {
		a = find(a);
		b = find(b);
		if(a.x ==b.x && a.y == b.y) return;
		u[a.y][a.x].y = b.y;
		u[a.y][a.x].x = b.x;
	}
}