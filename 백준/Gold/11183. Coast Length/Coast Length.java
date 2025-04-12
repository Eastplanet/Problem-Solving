import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int N,M;
	public static int[][] arr;
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	public static int result;

	public static void main(String[] args) throws Exception {

		init();
		
		int[][] visited = new int[N][M];
		
		Queue<int[]> q = new ArrayDeque<>();
		// 외부에서 접근 가능한 호수는 표시한다.
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if((i == 0 || i == N-1 || j == 0 || j == M-1) && arr[i][j] == 0) {
					q.add(new int[] {i,j});
					visited[i][j] = 1;
				}
			}
		}
		
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			arr[curr[0]][curr[1]] = -1;
			
			for(int i=0;i<4;i++) {
				int goy = curr[0] + dy[i];
				int gox = curr[1] + dx[i];
				
				if(gox < 0 || gox >= M || goy < 0 || goy >= N || visited[goy][gox] == 1 || arr[goy][gox] != 0) {
					continue;
				}
				
				visited[goy][gox] = 1;
				q.add(new int[] {goy,gox});
			}
		}
		
		
		// -1만 바다임
		visited = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 1 && visited[i][j] == 0) {
					
					q.add(new int[] {i,j});
					visited[i][j] = 1;
					
					while(!q.isEmpty()) {
						int[] curr = q.poll();
						
						for(int k=0;k<4;k++) {
							
							int gox = curr[1] + dx[k];
							int goy = curr[0] + dy[k];
							if(gox < 0 || gox >= M || goy < 0 || goy >= N || arr[goy][gox] == -1) {
								result++;
								continue;
							}
							if(visited[goy][gox] == 1 || arr[goy][gox] != 1) {
								continue;
							}
							
							visited[goy][gox] = 1;
							q.add(new int[] {goy,gox});
						}
					}
					
				}
			}
		}
		
		System.out.println(result);
	}
		

	public static int[][] BFS(int x,int y) {
		int length = 0;
		
		Queue<int[]> q = new ArrayDeque<>();
		int[][] visited = new int[N][M];
		
		
		
		return visited;
	}



	public static void init() throws Exception {

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String tmp = in.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j] = tmp.charAt(j)-'0';
			}
		}
	}

}