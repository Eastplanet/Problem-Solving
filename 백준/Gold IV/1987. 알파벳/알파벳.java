import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R;
	static int C;
	static int[][] map;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			String tmp = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j) - 'A';
			}
		}
		
		dfs(0,0,1,1<<map[0][0]);
		
		System.out.println(max);

	}

	public static boolean isIn(int x, int y) {
		if (x < 0 || x >= C)
			return false;
		if (y < 0 || y >= R)
			return false;
		return true;
	}

	public static void dfs(int x, int y, int count, int alpha) {
		
		if(count > max) {
			max = count;
		}
		
		
		for(int i=0;i<4;i++) {
			int gox = dx[i] + x;
			int goy = dy[i] + y;
			
			if(isIn(gox,goy)) {
				int c = map[goy][gox];
				if( ((alpha >> c) & 1) == 1)continue;
				
//				if(visited[goy][gox][alpha] == 1)continue;
				dfs(gox,goy,count+1, (alpha | (1<<c) ));
			}
		}
	}
}