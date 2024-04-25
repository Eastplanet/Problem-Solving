
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,K;
	static int[][] visited;
	static Pos[][] parent;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static Queue<Pos> q;
	
	static Pos root;
	
	public static void main(String[] args) throws Exception {
		
		init();
		
		int year = 0;
		while(true) {
			
			Pos find = find(root);
			if(parent[find.y][find.x].y == -1*K)break;
			
			q = BFS(q);
			
			year++;
		}
		
		System.out.println(year);
		
		
	}
	
	static Queue<Pos> BFS(Queue<Pos> q){
		Queue<Pos> nextq =new ArrayDeque<>();
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			
			for(int i=0;i<4;i++) {
				int gox = cur.x + dx[i];
				int goy = cur.y + dy[i];
				
				if(isIn(goy, gox) && visited[goy][gox] == 0) {
					
					Pos next = new Pos(goy,gox);
					
					visited[goy][gox] = 1;
					nextq.add(new Pos(goy,gox));
					unionNear(next);
				}
			}
		}
		
		
		return nextq;
	}

	static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new int[N+1][N+1];
		parent = new Pos[N+1][N+1];
		for(int i=0;i<=N;i++) {
			for(int j=0;j<=N;j++) {
				parent[i][j] = new Pos(i,j);
			}
		}
		
		q = new ArrayDeque<>();
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			Pos pos = new Pos(y,x);
			q.add(pos);
			
			if(i==0) {
				root = pos;
			}
			
			visited[y][x] = 1;
			parent[y][x].x = -1;
			parent[y][x].y = -1;
			
			unionNear(pos);
		}
		
	}
	
	
	//union 연산은 문명에서만 발생해야한다.
	static void unionNear(Pos pos) {
		for(int i=0;i<4;i++) {
			int gox = pos.x + dx[i];
			int goy = pos.y + dy[i];
			
			if(isIn(goy, gox) && visited[goy][gox] == 1) {
				union(pos, new Pos(goy,gox));
			}
		}
	}
	
	static boolean isIn(int y,int x) {
		if(x <= 0 || x> N)return false;
		if(y <= 0 || y> N)return false;
		return true;
	}
	
	static Pos find(Pos a) {
		Pos find = parent[a.y][a.x];
		if(Pos.isEqual(find, a) || find.x < 0) {
			return a;
		}
		return parent[a.y][a.x] = find(find);
	}
	
	
	
	
	static void union(Pos a,Pos b) {
		a = find(a);
		b = find(b);
		if(Pos.isEqual(a, b))return;
		
		if(parent[b.y][b.x].y < 0 && parent[a.y][a.x].y < 0) {
			parent[b.y][b.x].y += parent[a.y][a.x].y;
			parent[b.y][b.x].x += parent[a.y][a.x].x;
		}
		
		parent[a.y][a.x].y = b.y;
		parent[a.y][a.x].x = b.x;
		
		
	}
	
	static class Pos{
		int y,x;
		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
		public static boolean isEqual(Pos a,Pos b) {
			if(a.x == b.x && a.y == b.y)return true;
			return false;
		}
		@Override
		public String toString() {
			return "Pos [y=" + y + ", x=" + x + "]";
		}
		
	}
}
