import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	static int N;
	static int[][]map;
	static int[][]visit;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
	
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		visit = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String tmp = in.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		
		int normalCount = 0;
		Queue<Integer[]> q = new ArrayDeque<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visit[i][j]==0) {
					normalCount++;
					q.add(new Integer[] {i,j});
					
					while(!q.isEmpty()) {
						Integer[] curr = q.poll();
						
						for(int k=0;k<4;k++) {
							int gox = curr[1] + dx[k];
							int goy = curr[0] + dy[k];
							
							if(canGoForNormal(gox, goy, curr[1],curr[0])) {
								visit[goy][gox] = 1;
								q.add(new Integer[] {goy,gox});
							}
							
						}
					}
				}
			}
		}
		
		
		int redGreen = 0;
		q = new ArrayDeque<>();
		visit = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visit[i][j]==0) {
					redGreen++;
					q.add(new Integer[] {i,j});
					
					while(!q.isEmpty()) {
						Integer[] curr = q.poll();
						
						for(int k=0;k<4;k++) {
							int gox = curr[1] + dx[k];
							int goy = curr[0] + dy[k];
							
							if(canGoForRedGreen(gox, goy, curr[1],curr[0])) {
								visit[goy][gox] = 1;
								q.add(new Integer[] {goy,gox});
							}
							
						}
					}
				}
			}
		}
		
		System.out.println(normalCount+" "+redGreen);
		
		
	}
	
	public static boolean canGoForNormal(int x,int y,int currx,int curry) {
		if(x < 0 || x>= N)return false;
		if(y < 0 || y>= N)return false;
		if(map[y][x] != map[curry][currx])return false;
		if(visit[y][x] == 1)return false;
		
		return true;
	}
	
	public static boolean canGoForRedGreen(int x,int y,int currx,int curry) {
		if(x < 0 || x>= N)return false;
		if(y < 0 || y>= N)return false;
		if(visit[y][x] == 1)return false;
		
		if(map[curry][currx]=='R' || map[curry][currx]=='G') {
			if(map[y][x] == 'B')return false;
			
			return true;
		}
		else {
			if(map[y][x] != 'B')return false;
			
			return true;
		}
	}
}