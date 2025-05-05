import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int N,M;
	public static char[][] arr;
	
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception {
		
		init();
		
		int[][] visited = new int[N][M];
		Queue<int[]> q = new ArrayDeque<>();
		
		
		int cnt = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(visited[i][j] == 0 && arr[i][j] == '#') {
					cnt++;
					visited[i][j] = 1;
					q.add(new int[] {i,j});
					
					while(!q.isEmpty()) {
						int[] curr = q.poll();
						
						for(int k=0;k<4;k++) {
							int gox = dx[k] + curr[1];
							int goy = dy[k] + curr[0];
							if(gox < 0 || gox >= M || goy < 0 || goy >= N || visited[goy][gox] == 1 || arr[goy][gox]=='.') {
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
	
	public static void init() throws Exception{
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		
		for(int i=0;i<N;i++) {
			String tmp = in.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j] = tmp.charAt(j);
			}
		}
	}


}