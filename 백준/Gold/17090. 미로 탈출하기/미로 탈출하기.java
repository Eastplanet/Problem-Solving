import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

/*
 * 1. 갈 수 있는 칸들은 같은 집합으로 구성한다
 * 해당 집합이 밖으로 가는지 사이클을 구성하는지 root로 확인할 수 있도록 한다
 * 2. 다른 집합과 만나면 그 집합을 부모로 하여 merge한다.
 * 3. N x M 돌면서 해당 칸이 밖으로 가는지 검사한다. (잘 하면 이 과정 없이도 칸 수 구할 수 있을듯)
 */
public class Main {

	static int N, M;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] map, visited;
	static Pos[][] disjointSet;

	public static void main(String[] args) throws Exception {
		init();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(visited[i][j] == 0) {
					DFS(i,j);
				}
			}
		}
		
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				Pos pos = find(new Pos(i,j));
				Pos root = disjointSet[pos.y][pos.x];
				if(root.isOut)cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	static void DFS(int y,int x) {
		visited[y][x] = 1;
		
		int dir = map[y][x];
		int gox = x + dx[dir];
		int goy = y + dy[dir];
		
		if(isIn(goy, gox)) {
			// 같은 집합으로 만든다.
			merge(new Pos(goy,gox), new Pos(y,x));
 			if(visited[goy][gox]==0) {
				DFS(goy,gox);
			}
		}
		// 밖으로 갈 수 있다면 기록한다.
		else {
			Pos pos = disjointSet[y][x];
			pos.isOut = true;
		}
	}
	
	static boolean isIn(int y,int x) {
		if(x < 0 || x>= M)return false;
		if(y < 0 || y>= N)return false;
		return true;
	}

	
	static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		disjointSet = new Pos[N][M];
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			String tmp = in.readLine();
			for (int j = 0; j < M; j++) {
				// 분리 집합 초기화
				disjointSet[i][j] = new Pos(-1,-1);
				// map[i][j] 가 가야할 방향 저장
				char c = tmp.charAt(j);
				switch (c) {
				case 'D':
					map[i][j] = 0;
					break;
				case 'U':
					map[i][j] = 1;
					break;
				case 'R':
					map[i][j] = 2;
					break;
				case 'L':
					map[i][j] = 3;
					break;
				}
			}
		}
	}
	
	static class Pos{
		int y,x;
		boolean isOut;
		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
		static boolean isEqual(Pos a, Pos b) {
			if(a.x == b.x && a.y == b.y)return true;
			return false;
		}
	}
	
	static Pos find(Pos a) {
		if(disjointSet[a.y][a.x].x == -1)return a;
		return disjointSet[a.y][a.x] = find(disjointSet[a.y][a.x]); 
	}
	
	// a가 부모 b가 자식으로 merge
	static void merge(Pos a,Pos b) {
		a = find(a);
		b = find(b);
		if(Pos.isEqual(a, b))return;
		disjointSet[b.y][b.x].y = a.y;
		disjointSet[b.y][b.x].x = a.x;
	}
}