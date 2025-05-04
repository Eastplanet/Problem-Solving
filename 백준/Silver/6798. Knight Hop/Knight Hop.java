import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int[] start,end;
	public static int[][] visited;
	
	public static int[] dx = {-2,-1,1,2,2,1,-1,-2};
	public static int[] dy = {-1,-2,-2,-1,1,2,2,1};
	
	public static void main(String[] args) throws Exception {
		
		init();
		
		Queue<int[]> q = new ArrayDeque<>();
		visited[start[0]][start[1]] = 1;
		q.add(new int[] {start[0],start[1],0});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			if(curr[0] == end[0] && curr[1] == end[1]) {
				System.out.println(curr[2]);
				return;
			}
			
			for(int i=0;i<8;i++) {
				int goy = curr[0] + dy[i];
				int gox = curr[1] + dx[i];
				
				if(gox < 1 || gox > 8 || goy < 1 || goy > 8 || visited[goy][gox] == 1) {
					continue;
				}
				visited[goy][gox] = 1;
				q.add(new int[] {goy,gox,curr[2] +1});
			}
		}
		
	}
	
	public static void init() throws Exception{
		StringTokenizer st = new StringTokenizer(in.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		start = new int[] {b,a};
		
		visited = new int[9][9];
		
		st = new StringTokenizer(in.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		end = new int[] {b,a};
	}


}