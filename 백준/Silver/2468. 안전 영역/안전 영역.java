import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int N, maxSafeCnt;
	public static int[][] arr;

	public static void main(String[] args) throws Exception {

		init();

		for(int i=0;i<101;i++) {
			maxSafeCnt = Math.max(maxSafeCnt, BFS(i));
		}
		
		System.out.println(maxSafeCnt);
	}
	
	public static int BFS(int rainHeight) {
		
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		int[][] visited = new int[N][N];
		Queue<int[]> q = new ArrayDeque<>();
		
		int safeCnt = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j] >= rainHeight && visited[i][j] == 0) {
					safeCnt++;
					visited[i][j] = 1;
					q.add(new int[] {i,j});
					
					while(!q.isEmpty()) {
						int[] curr = q.poll();
						
						for(int k=0;k<4;k++) {
							int gox = curr[1] + dx[k];
							int goy = curr[0] + dy[k];
							
							if(gox < 0 || gox >= N || goy < 0 || goy >= N || visited[goy][gox] == 1 || arr[goy][gox] < rainHeight) {
								continue;
							}
							
							visited[goy][gox] = 1;
							q.add(new int[] {goy,gox});
						}
					}
				}
			}
		}
		
		return safeCnt;
	}
	


	public static void init() throws Exception {
		N = Integer.parseInt(in.readLine());
		
		arr = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}