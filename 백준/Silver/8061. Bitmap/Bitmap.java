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
	public static int[][] visited;
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception {
		
		init();
		
		Queue<int[]> q = new ArrayDeque<>();
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 1) {
					q.add(new int[] {i,j,1});
					visited[i][j] = 1;
					
					while(!q.isEmpty()) {
						int[] curr = q.poll();
						
						for(int k=0;k<4;k++) {
							int gox = curr[1] + dx[k];
							int goy = curr[0] + dy[k];
							
							if(gox < 0 || gox >= M || goy < 0 || goy >= N || arr[goy][gox] == 1 || (visited[goy][gox] != 0 && visited[goy][gox] <= curr[2] + 1)){
								continue;
							}
							
							visited[goy][gox] = curr[2] + 1;
							q.add(new int[] {goy,gox,curr[2]+1});
						}
					}
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(visited[i][j]-1 + " ");
			}
			System.out.println();
		}
		
	}
	
	public static void init() throws Exception{
		
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String tmp = in.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j] = tmp.charAt(j)-'0';
			}
		}
	}


}