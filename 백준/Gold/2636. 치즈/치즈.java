import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] dy = {0,0,1,-1};
		int[] dx = {1,-1,0,0};
		int C,R;
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int deIceCount = -1;
		
		int time = 0;
		
		for(;;time++) {
			
			int[][] visit = new int[R][C];
			Queue<Integer[]>q = new ArrayDeque<>();
			q.add(new Integer[] {0,0});
			visit[0][0] = 1;
			
			int cheseeCount = 0;
			
			while(!q.isEmpty()) {
				Integer[] curr = q.poll();
				
				for(int i=0;i<4;i++) {
					int goy = curr[0] + dy[i];
					int gox = curr[1] + dx[i];
					
					if(gox < 0 || gox >= C || goy < 0 || goy >= R) {
						continue;
					}
					
					if(visit[goy][gox] == 1) {
						continue;
					}
					
					
					if(map[goy][gox] == 1) {
						visit[goy][gox] = 1;
						cheseeCount++;
						map[goy][gox] = 0;
						continue;
					}
					else {
						visit[goy][gox] = 1;
						q.add(new Integer[] {goy,gox});
						continue;
					}
					
				}
			}
			
			if(cheseeCount == 0 ) {
				break;
			}
			else {
				deIceCount = cheseeCount;
			}
			
		}
		
		System.out.println(time);
		System.out.println(deIceCount);
	}
}