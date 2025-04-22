import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		int[][] arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		
		int[] dx = {0,0,1,-1,1,1,-1,-1};
		int[] dy = {1,-1,0,0,-1,1,1,-1};
		
		
		int[][] visited =  new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				
				if(visited[i][j] == 0 && arr[i][j] >= 1) {
					visited[i][j] = 1;
					cnt++;
					Queue<int[]> q = new ArrayDeque<>();
					q.add(new int[] {i,j});
					
					while(!q.isEmpty()) {
						int[] curr = q.poll();
						
						
						for(int k=0;k<8;k++) {
							int gox = curr[1] + dx[k];
							int goy = curr[0] + dy[k];
							
							if(gox < 0 || gox >= M || goy < 0 || goy >= N || visited[goy][gox] == 1|| arr[goy][gox] == 0) {
								continue;
							}
							
							visited[goy][gox] = 1;
							q.add(new int[] {goy,gox});
						}
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
	

}