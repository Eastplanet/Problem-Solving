import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][] map;
	static int[][][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new int[N][M][1<<6];
		
		Queue<Integer[]>q = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			String tmp = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j);
				if(map[i][j] == '0') {
					map[i][j] = '.';
					q.add(new Integer[] {i,j,0,0});
					visited[i][j][0] = 1;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Integer[] curr = q.poll();
			
			if(map[curr[0]][curr[1]] == '1') {
				
				System.out.println(curr[3]);
				return;
			}
			
			for(int i=0;i<4;i++) {
				int gox = curr[1] + dx[i];
				int goy = curr[0] + dy[i];
				
				if(isIn(gox,goy)) {
					if(visited[goy][gox][curr[2]] == 1)continue;
					if(map[goy][gox] == '#')continue;
					
					if(map[goy][gox] == '.' || map[goy][gox] == '1') {
						visited[goy][gox][curr[2]] = 1;
						q.add(new Integer[] {goy,gox,curr[2],curr[3]+1});
						continue;
					}
					else if('a' <= map[goy][gox] && map[goy][gox] <= 'f') {
						visited[goy][gox][curr[2]] = 1;
						int tmpKey = curr[2];
						tmpKey = tmpKey | (1<<(map[goy][gox] - 'a'));
						q.add(new Integer[] {goy,gox,tmpKey,curr[3]+1});
						continue;
					}
					else if('A' <= map[goy][gox] && map[goy][gox] <= 'F') {
						int tmp = (curr[2] >> (map[goy][gox] - 'A')) & 1;
						if(tmp == 0)continue;
						
						visited[goy][gox][curr[2]] = 1;
						q.add(new Integer[] {goy,gox,curr[2],curr[3]+1});
						continue;
					}
				}
			}
			
		}
		
		System.out.println("-1");
		
		
	}
	

	public static boolean isIn(int x, int y) {
		if (x < 0 || x >= M)
			return false;
		if (y < 0 || y >= N)
			return false;

		return true;
	}
}