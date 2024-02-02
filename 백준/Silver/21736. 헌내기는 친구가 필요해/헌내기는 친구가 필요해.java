import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	
	static class Point{
		int x,y;
		Point(int y,int x){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		int[][]visited = new int[N][M];
		int[][]movepos = {{0,1},{0,-1},{1,0},{-1,0}};
		
		Point start = null;
		
		for(int i=0;i<N;i++) {
			String data = in.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = data.charAt(j);
				if(map[i][j] == 'I') {
					
					start = new Point(i,j);
					
				}
			}
		}
		
		Queue<Point>q = new ArrayDeque<>();
		q.add(start);
		
		int pCount = 0;
		
		while(!q.isEmpty()) {
			Point curr = q.poll();
			
			visited[curr.y][curr.x] = 1;
			
			if(map[curr.y][curr.x]=='P') {
				pCount++;
			}
			
			for(int i=0;i<4;i++) {
				int goy = curr.y+movepos[i][0];
				int gox = curr.x+movepos[i][1];
				if(isIn(goy,gox)) {
					if(map[goy][gox]=='X')continue;
					if(visited[goy][gox]==1)continue;
					visited[goy][gox]=1;
					q.add(new Point(goy,gox));
				}
				
			}
			
		}
		
		if(pCount == 0)sb.append("TT");
		else sb.append(pCount);
		
		System.out.println(sb);
		
	}
	
	public static boolean isIn(int y, int x) {
		if(y<0 || y>= N)return false;
		if(x<0 || x>= M)return false;
		return true;
	}
}