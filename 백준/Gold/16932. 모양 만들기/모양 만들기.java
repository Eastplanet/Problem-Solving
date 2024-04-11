import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int[][]map,visited;
	static Pos[][]parent;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		init();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 1 && visited[i][j] == 0) {
					BFS(i,j);
				}
			}
		}
		
		
		int max = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				
			
				// 현재 위치가 0인 경우
				// 주변과 연결 시도
				if(map[i][j] == 0) {

					Set<Pos> set = new HashSet<>();
					
					int sum = 1;
					
					for(int k=0;k<4;k++) {
						int gox = j + dx[k];
						int goy = i + dy[k];
						if(!isIn(goy, gox))continue;
						if(map[goy][gox] == 1) {
							Pos p = find(new Pos(goy,gox));
							if(!set.contains(p)) {
								set.add(p);
								sum+= parent[p.y][p.x].x*-1;
							}
						}
					}
					
					if(sum > max)max = sum;
				}
				// 현재 위치가 1인 경우
				//이미 주변과 연결되어 있음
				else {
					Pos pos = find(new Pos(i,j));
					
					int nowSize = parent[pos.y][pos.x].x * -1;
					if(nowSize > max )max = nowSize;
				}
				
				
				
			}
		}
		
		System.out.println(max);
		
	}
	
	static void BFS(int y,int x) {
		
		visited[y][x] = 1;
		Queue<Pos> q = new ArrayDeque<>();
		q.add(new Pos(y,x));
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			
			for(int i=0;i<4;i++) {
				int gox = cur.x + dx[i];
				int goy = cur.y + dy[i];
				if(!isIn(goy, gox) || map[goy][gox] == 0 || visited[goy][gox] == 1)continue;
				
				visited[goy][gox] = 1;
				union(cur,new Pos(goy,gox));
				q.add(new Pos(goy,gox));
			}
		}
	}
	
	static boolean isIn(int y,int x) {
		if(x < 0 || x>= M) return false;
		if(y < 0 || y>= N)return false;
		return true;
	}
	
	static void init() throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		parent = new Pos[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				parent[i][j] = new Pos(-1,-1);
			}
		}
	}
	
	static Pos find(Pos a) {
		if(parent[a.y][a.x].x < 0)return a;
		return parent[a.y][a.x] = find(parent[a.y][a.x]);
	}
	
	static void union(Pos a,Pos b) {
		a = find(a);
		b = find(b);
		if(Pos.isEqual(a, b))return;
		
		parent[a.y][a.x].y += parent[b.y][b.x].y; 
		parent[a.y][a.x].x += parent[b.y][b.x].x; 
		parent[b.y][b.x].y = a.y;
		parent[b.y][b.x].x = a.x;
		
	}
	
	static class Pos{
		int y,x;
		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
		public static boolean isEqual(Pos a,Pos b) {
			if(a.x == b.x && a.y == b.y)return true;
			else return false;
		}
		@Override
		public String toString() {
			return "Pos [y=" + y + ", x=" + x + "]";
		}
		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
		@Override
		public boolean equals(Object obj) {
			Pos other = (Pos) obj;
			return x == other.x && y == other.y;
		}
		
	}
}