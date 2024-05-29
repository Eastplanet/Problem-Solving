import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	static int N;
	static int[][] adj,visited, dist;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		adj = new int[N][N];
		visited = new int[N][N];
		dist = new int[N][N];
		
		
		for(int i=0;i<N;i++) {
			String tmp = in.readLine();
			for(int j=0;j<N;j++) {
				if(tmp.charAt(j) == '1')adj[i][j] = 0;
				else adj[i][j] =1;
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		PriorityQueue<int[]> PQ = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
		PQ.add(new int[] {0,0,0});
		
		
		while(!PQ.isEmpty()) {
			int[] curr = PQ.poll();
			
			if(visited[curr[0]][curr[1]] == 1) {
				if(!PQ.isEmpty()) {
					curr = PQ.poll();
				}
				else {
					break;
				}
			}
			
			dist[curr[0]][curr[1]] = curr[2];
			visited[curr[0]][curr[1]] = 1;
			
			
			if(curr[0] == N-1 && curr[1] == N-1) {
				System.out.println(curr[2]);
				break;
			}
			
			for(int i=0;i<4;i++) {
				int gox = curr[1] + dx[i];
				int goy = curr[0] + dy[i];
				
				if(canGo(goy, gox) && visited[goy][gox] == 0) {
					if(dist[goy][gox] > dist[curr[0]][curr[1]] + adj[curr[0]][curr[1]]) {
						PQ.add(new int[] {goy,gox,dist[curr[0]][curr[1]] + adj[goy][gox]});
						
					}
					
				}
			}
			
			
		}
		
	}
	
	static boolean canGo(int goy,int gox) {
		if(gox < 0 || gox >= N || goy < 0 || goy >= N)return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}