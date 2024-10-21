import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
	
		st = new StringTokenizer(in.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		Queue<int[]> q = new ArrayDeque<>();
		
		int[][] visited = new int[N][M];
		
		visited[0][0] = 1;
		q.add(new int[] {0,0});
		
		int[] dx = new int[] {0,1};
		int[] dy = new int[] {1,0};
		
		boolean result = false;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			if(curr[0] == N-1 && curr[1] == M-1) {
				result = true;
			}
			
			
			for(int i=0;i<2;i++) {
				int gox = curr[1] + dx[i];
				int goy = curr[0] + dy[i];
				if(gox < 0 || gox >= M || goy < 0 || goy >= N)continue;
				if(arr[goy][gox] == 0 || visited[goy][gox] == 1)continue;
				visited[goy][gox] = 1;
				q.add(new int[] {goy,gox});
			}
			
		}
		
		if(result) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
		
		
	}
	

}